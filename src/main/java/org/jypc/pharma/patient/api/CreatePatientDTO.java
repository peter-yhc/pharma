package org.jypc.pharma.patient.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePatientDTO {

    private String username;
    private String password;
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

}
