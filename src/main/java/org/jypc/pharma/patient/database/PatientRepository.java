package org.jypc.pharma.patient.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


/**
 * Database manager for the Patient table
 * Use this to create, update, and retrieve entries from Patient table
 **/
@Component
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
