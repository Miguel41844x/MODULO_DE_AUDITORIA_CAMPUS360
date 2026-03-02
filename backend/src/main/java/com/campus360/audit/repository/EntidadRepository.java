package com.campus360.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.campus360.audit.domain.Entidad;

public interface EntidadRepository extends JpaRepository<Entidad, Long> {
}