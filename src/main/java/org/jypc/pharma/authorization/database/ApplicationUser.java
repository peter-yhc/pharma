package org.jypc.pharma.authorization.database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents the database ApplicationUser table.
 * This is currently used to store administrators of the application, but can be enhanced to store additional
 * types of users if Roles are defined.
 **/
@Entity
@Setter
@Getter
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
}
