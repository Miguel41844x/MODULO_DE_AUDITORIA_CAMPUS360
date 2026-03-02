package com.campus360.audit.dto;

import java.time.LocalDateTime;

public class EventoExportDTO {

    private Long idEvento;
    private String usuario;
    private String rol;
    private String accion;
    private String entidad;
    private LocalDateTime fecha;
    private String descripcion;

    public EventoExportDTO() {}

    public EventoExportDTO(Long idEvento,
                           String usuario,
                           String rol,
                           String accion,
                           String entidad,
                           LocalDateTime fecha,
                           String descripcion) {

        this.idEvento = idEvento;
        this.usuario = usuario;
        this.rol = rol;
        this.accion = accion;
        this.entidad = entidad;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Long getIdEvento() { return idEvento; }
    public void setIdEvento(Long idEvento) { this.idEvento = idEvento; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public String getAccion() { return accion; }
    public void setAccion(String accion) { this.accion = accion; }

    public String getEntidad() { return entidad; }
    public void setEntidad(String entidad) { this.entidad = entidad; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}