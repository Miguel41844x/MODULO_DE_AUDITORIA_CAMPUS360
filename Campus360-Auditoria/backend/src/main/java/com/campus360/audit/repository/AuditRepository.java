package com.campus360.audit.repository;

import com.campus360.audit.domain.AuditEvent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AuditRepository {

    private final List<AuditEvent> events = new ArrayList<>();

    public AuditRepository() {

        events.add(new AuditEvent(
                1L,
                "2026-05-01 10:15",
                "admin",
                "Administrador",
                "CREATED",
                "Solicitud",
                "SOL-001",
                null,
                "Solicitud creada"
        ));

        events.add(new AuditEvent(
                2L,
                "2026-05-02 11:30",
                "auditor1",
                "Auditor",
                "UPDATED",
                "Solicitud",
                "SOL-001",
                "Pendiente",
                "Aprobada"
        ));
    }

    public List<AuditEvent> findAll() {
        return events;
    }

    public Optional<AuditEvent> findById(Long id) {
        return events.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    public List<AuditEvent> findByEntityId(String entityId) {
        return events.stream()
                .filter(e -> e.getEntityId().equals(entityId))
                .toList();
    }
}
