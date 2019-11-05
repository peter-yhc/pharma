package org.jypc.pharma.authorization.database;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Database manager for the ApplicationUser table
 * Use this to create, update, and retrieve entries from ApplicationUser table
 **/
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}