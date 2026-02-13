package com.campus360.audit.domain;

public class AuditEvent {

    private Long id;
    private String timestamp;
    private String user;
    private String role;
    private String action;
    private String entity;
    private String entityId;
    private String oldValue;
    private String newValue;

    public AuditEvent() {}

    public AuditEvent(Long id, String timestamp, String user, String role,
                      String action, String entity, String entityId,
                      String oldValue, String newValue) {
        this.id = id;
        this.timestamp = timestamp;
        this.user = user;
        this.role = role;
        this.action = action;
        this.entity = entity;
        this.entityId = entityId;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public Long getId() { return id; }
    public String getTimestamp() { return timestamp; }
    public String getUser() { return user; }
    public String getRole() { return role; }
    public String getAction() { return action; }
    public String getEntity() { return entity; }
    public String getEntityId() { return entityId; }
    public String getOldValue() { return oldValue; }
    public String getNewValue() { return newValue; }
}
