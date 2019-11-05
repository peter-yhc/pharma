package org.jypc.pharma.patient.api;

import org.jypc.pharma.patient.database.Patient;
import org.jypc.pharma.patient.database.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public List<PatientDTO> getPatients() {
        return patientRepository
            .findAll()
            .stream()
            .map(PatientDTO::fromPatient)
            .collect(toList());
    }

    @GetMapping("/{patientId}")
    public PatientDTO getPatients(@PathVariable Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(PatientNotFoundException::new);
        return PatientDTO.fromPatient(patient);
    }

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
}
