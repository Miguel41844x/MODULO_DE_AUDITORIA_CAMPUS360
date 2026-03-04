package com.campus360.audit.service;

import com.campus360.audit.domain.*;
import com.campus360.audit.repository.*;
import org.springframework.stereotype.Service;
import com.campus360.audit.dto.EventoExportDTO;

import java.util.List;

@Service
public class AuditoriaService {

    private final EventoAuditoriaRepository eventoRepo;
    private final EntidadRepository entidadRepo;
    private final UsuarioRepository usuarioRepo;

    public AuditoriaService(EventoAuditoriaRepository eventoRepo,
                            EntidadRepository entidadRepo,
                            UsuarioRepository usuarioRepo) {
        this.eventoRepo = eventoRepo;
        this.entidadRepo = entidadRepo;
        this.usuarioRepo = usuarioRepo;
    }

    /*
      LISTAR TODOS
     */
    public List<EventoAuditoria> obtenerTodos() {
        return eventoRepo.findAll();
    }

    /*
      HISTORIAL POR ENTIDAD
     */
    public List<EventoAuditoria> obtenerHistorial(Long idEntidad) {
        return eventoRepo.findByEntidad_IdEntidad(idEntidad);
    }

    /*
      MÉTODOS PRIVADOS (REFACTORIZACIÓN)
     */
    private Usuario obtenerUsuario(Long id) {
        return usuarioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));
    }

    private Entidad obtenerEntidad(Long id) {
        return entidadRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Entidad no existe"));
    }

    /*
      GUARDAR EVENTO (POSTMAN)
     */
    public EventoAuditoria guardarEvento(EventoAuditoria evento) {

        Usuario usuario = obtenerUsuario(
                evento.getUsuario().getIdUsuario()
        );

        Entidad entidad = obtenerEntidad(
                evento.getEntidad().getIdEntidad()
        );

        evento.setUsuario(usuario);
        evento.setEntidad(entidad);

        // Enlazar cambios al evento
        if (evento.getCambios() != null) {
            for (Cambio cambio : evento.getCambios()) {
                cambio.setEvento(evento);
            }
        }

        return eventoRepo.save(evento);
    }

    /*
      REGISTRAR CAMBIO AUTOMATICO (USANDO BUILDER)
     */
    public EventoAuditoria registrarCambioEstado(Long entidadId,
                                                 String nuevoEstado,
                                                 Long usuarioId) {

        Entidad entidad = obtenerEntidad(entidadId);
        Usuario usuario = obtenerUsuario(usuarioId);

        // Crear cambio
        Cambio cambio = new Cambio();
        cambio.setCampo("estado");
        cambio.setValorAntiguo("Anterior");
        cambio.setValorNuevo(nuevoEstado);

        // Crear evento usando BUILDER
        EventoAuditoria evento = EventoAuditoria.builder()
                .accion("CAMBIO_ESTADO")
                .descripcion("Cambio automático de estado")
                .usuario(usuario)
                .entidad(entidad)
                .cambios(List.of(cambio))
                .build();

        return eventoRepo.save(evento);
    }

    /*
      CONVERTIR A DTO
     */
    public List<EventoExportDTO> obtenerEventosParaExportar() {

        List<EventoAuditoria> eventos = eventoRepo.findAll();

        return eventos.stream().map(e -> new EventoExportDTO(
                e.getIdEvento(),
                e.getUsuario() != null ? e.getUsuario().getNombre() : "",
                e.getUsuario() != null ? e.getUsuario().getRol() : "",
                e.getAccion(),
                e.getEntidad() != null ? e.getEntidad().getTipoEntidad() : "",
                e.getFecha(),
                e.getDescripcion()
        )).toList();
    }
}