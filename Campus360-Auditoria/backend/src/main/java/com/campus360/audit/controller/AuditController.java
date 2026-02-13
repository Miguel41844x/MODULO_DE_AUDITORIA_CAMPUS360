package com.campus360.audit.controller;

import com.campus360.audit.domain.AuditEvent;
import com.campus360.audit.service.AuditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit")
@CrossOrigin
public class AuditController {

    private final AuditService service;

    public AuditController(AuditService service) {
        this.service = service;
    }

    @GetMapping("/events")
    public List<AuditEvent> getEvents() {
        return service.getAllEvents();
    }

    @GetMapping("/events/{id}")
    public AuditEvent getEvent(@PathVariable Long id) {
        return service.getEventById(id);
    }

    @GetMapping("/history/{entityId}")
    public List<AuditEvent> getHistory(@PathVariable String entityId) {
        return service.getHistory(entityId);
    }
}
