package com.campus360.audit.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "evento_auditoria")
public class EventoAuditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvento;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private String accion;

    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entidad_id", nullable = false)
    private Entidad entidad;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cambio> cambios;

    public EventoAuditoria() {}

    @PrePersist
    protected void prePersist() {
        this.fecha = LocalDateTime.now();
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public List<Cambio> getCambios() {
        return cambios;
    }

    public void setCambios(List<Cambio> cambios) {
        this.cambios = cambios;

        // Enlazar cada cambio con el evento
        if (cambios != null) {
            for (Cambio c : cambios) {
                c.setEvento(this);
            }
        }
    }

    /*
     =========================
     BUILDER PATTERN
     =========================
     */
    public static class Builder {

        private EventoAuditoria evento;

        public Builder() {
            evento = new EventoAuditoria();
        }

        public Builder accion(String accion) {
            evento.setAccion(accion);
            return this;
        }

        public Builder descripcion(String descripcion) {
            evento.setDescripcion(descripcion);
            return this;
        }

        public Builder usuario(Usuario usuario) {
            evento.setUsuario(usuario);
            return this;
        }

        public Builder entidad(Entidad entidad) {
            evento.setEntidad(entidad);
            return this;
        }

        public Builder cambios(List<Cambio> cambios) {
            evento.setCambios(cambios);
            return this;
        }

        public EventoAuditoria build() {

            if (evento.accion == null || evento.accion.isEmpty()) {
                throw new IllegalStateException("La acción es obligatoria");
            }

            if (evento.usuario == null) {
                throw new IllegalStateException("El usuario es obligatorio");
            }

            if (evento.entidad == null) {
                throw new IllegalStateException("La entidad es obligatoria");
            }

            return evento;
        }
    }

    /*
     Método estático para iniciar el builder
     */
    public static Builder builder() {
        return new Builder();
    }
}