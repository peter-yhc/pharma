package org.jypc.pharma.patient.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jypc.pharma.patient.database.Patient;

@Data
@AllArgsConstructor
public class PatientDTO {

    private String username;
    private String name;
    private Integer age;
    private String sex;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String phone1;
    private String phone2;
    private String emergencyContactName;
    private String emergencyContactPhone;

    static PatientDTO fromPatient(Patient patient) {
        return new PatientDTO(
                patient.getUsername(),
                patient.getName(),
                patient.getAge(),
                patient.getSex(),
                patient.getAddress(),
                patient.getCity(),
                patient.getCountry(),
                patient.getPostalCode(),
                patient.getPhone1(),
                patient.getPhone2(),
                patient.getEmergencyContactName(),
                patient.getEmergencyContactPhone()
        );
    }
}
