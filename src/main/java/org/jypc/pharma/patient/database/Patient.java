package org.jypc.pharma.patient.database;

import com.sun.istack.NotNull;
import lombok.Data;
import org.jypc.pharma.trial.Trial;

import javax.persistence.*;
import java.util.Set;

/**
 * Represents the database Patient table
**/
@Data
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull private String username;
    @NotNull private String password;
    @NotNull private String name;
    @NotNull private Integer age;
    @NotNull private String sex;
    @NotNull private String address;
    @NotNull private String city;
    @NotNull private String country;
    @NotNull private String postalCode;
    @NotNull private String phone1;
    private String phone2;
    @NotNull private String emergencyContactName;
    @NotNull private String emergencyContactPhone;
    private String userLevel;

    @OneToMany
    private Set<Trial> activeTrials;

    @OneToMany
    private Set<Trial> pastTrials;

}
