package com.campus360.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.campus360.audit.domain.EventoAuditoria;
import java.util.List;

public interface EventoAuditoriaRepository 
        extends JpaRepository<EventoAuditoria, Long> {

    List<EventoAuditoria> findByEntidad_IdEntidad(Long idEntidad);
}