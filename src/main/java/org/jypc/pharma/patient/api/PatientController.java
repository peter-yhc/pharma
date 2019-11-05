package org.jypc.pharma.patient.api;

import org.jypc.pharma.patient.database.Patient;
import org.jypc.pharma.patient.database.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * Exposes endpoints at host:8080/patients
 **/
@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Exposes an endpoint at host:8080/patients to retrieve all patients using GET
     **/
    @GetMapping("/")
    public List<PatientDTO> getPatients() {
        return patientRepository
            .findAll()
            .stream()
            .map(PatientDTO::fromPatient)
            .collect(toList());
    }


    /**
     * Exposes an endpoint at host:8080/patients/{patientId} to retrieve one patient using GET
     **/
    @GetMapping("/{patientId}")
    public PatientDTO getPatients(@PathVariable Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(PatientNotFoundException::new);
        return PatientDTO.fromPatient(patient);
    }


    /**
     * Exposes an endpoint at host:8080/patients to create new patients using POST
     **/
    @PostMapping("/")
    public void createPatient(CreatePatientDTO dto) {
        Patient patient = new Patient();
        patient.setUsername(dto.getUsername());
        patient.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        patient.setSex(dto.getSex());
        patient.setAddress(dto.getAddress());
        patient.setCity(dto.getCity());
        patient.setCountry(dto.getCountry());
        patient.setPostalCode(dto.getPostalCode());
        patient.setPhone1(dto.getPhone1());
        patient.setPhone2(dto.getPhone2());
        patient.setEmergencyContactName(dto.getEmergencyContactName());
        patient.setEmergencyContactPhone(dto.getEmergencyContactPhone());

        patientRepository.save(patient);
    }


    /**
     * Exposes an endpoint at host:8080/patients/{patientId} to update a patient using PATCH
     **/
    @PatchMapping("/{patientId}")
    public void updatePatient(@RequestBody Map<String, Object> updates, @PathVariable Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(PatientNotFoundException::new);

        // Map key is field name, v is value
        updates.forEach((k, v) -> {
            // use reflection to get field k on manager and set it to value k
            Field field = ReflectionUtils.findField(Patient.class, k);
            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, patient, v);
        });
        patientRepository.save(patient);
    }


    /**
     * Returns 404 not found if any PatientNotFoundException is thrown in the application
     **/
    @ExceptionHandler(value = PatientNotFoundException.class)
    public ResponseEntity notFoundExceptionHandler() {
        return ResponseEntity.notFound().build();
    }
}
