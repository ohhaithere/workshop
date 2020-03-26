package com.epam.workshop.repository;

import com.epam.workshop.model.AuditModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<AuditModel, Long> {

}
