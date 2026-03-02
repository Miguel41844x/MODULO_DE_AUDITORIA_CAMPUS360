package com.campus360.audit.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Cambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCambio;

    private String campo;
    private String valorAntiguo;
    private String valorNuevo;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    @JsonBackReference
    private EventoAuditoria evento;

    public Cambio() {}

    public Long getIdCambio() { return idCambio; }
    public void setIdCambio(Long idCambio) { this.idCambio = idCambio; }

    public String getCampo() { return campo; }
    public void setCampo(String campo) { this.campo = campo; }

    public String getValorAntiguo() { return valorAntiguo; }
    public void setValorAntiguo(String valorAntiguo) { this.valorAntiguo = valorAntiguo; }

    public String getValorNuevo() { return valorNuevo; }
    public void setValorNuevo(String valorNuevo) { this.valorNuevo = valorNuevo; }

    public EventoAuditoria getEvento() { return evento; }
    public void setEvento(EventoAuditoria evento) { this.evento = evento; }
}