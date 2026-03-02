package com.campus360.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.campus360.audit.domain.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {
}