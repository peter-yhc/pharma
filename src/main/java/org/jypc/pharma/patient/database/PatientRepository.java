package org.jypc.pharma.patient.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
