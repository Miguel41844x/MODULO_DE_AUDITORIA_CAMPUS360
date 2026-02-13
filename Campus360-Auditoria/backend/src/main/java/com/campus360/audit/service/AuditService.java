package com.campus360.audit.service;

import com.campus360.audit.domain.AuditEvent;
import com.campus360.audit.repository.AuditRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditService {

    private final AuditRepository repository;

    public AuditService(AuditRepository repository) {
        this.repository = repository;
    }

    public List<AuditEvent> getAllEvents() {
        return repository.findAll();
    }

    public AuditEvent getEventById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));
    }

    public List<AuditEvent> getHistory(String entityId) {
        return repository.findByEntityId(entityId);
    }
}
