package org.jypc.pharma.patient.api;

import org.jypc.pharma.patient.database.Patient;
import org.jypc.pharma.patient.database.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
