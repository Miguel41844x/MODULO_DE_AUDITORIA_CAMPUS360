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
      GUARDAR EVENTO (POSTMAN)
     */
    public EventoAuditoria guardarEvento(EventoAuditoria evento) {

        // Validar usuario
        Usuario usuario = usuarioRepo.findById(
                evento.getUsuario().getIdUsuario()
        ).orElseThrow(() -> new RuntimeException("Usuario no existe"));

        // Validar entidad
        Entidad entidad = entidadRepo.findById(
                evento.getEntidad().getIdEntidad()
        ).orElseThrow(() -> new RuntimeException("Entidad no existe"));

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
      REGISTRAR CAMBIO AUTOMATICO
     */
    public EventoAuditoria registrarCambioEstado(Long entidadId,
                                                 String nuevoEstado,
                                                 Long usuarioId) {

        Entidad entidad = entidadRepo.findById(entidadId)
                .orElseThrow(() -> new RuntimeException("Entidad no encontrada"));

        Usuario usuario = usuarioRepo.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        EventoAuditoria evento = new EventoAuditoria();
        evento.setAccion("CAMBIO_ESTADO");
        evento.setDescripcion("Cambio automático de estado");
        evento.setUsuario(usuario);
        evento.setEntidad(entidad);

        Cambio cambio = new Cambio();
        cambio.setCampo("estado");
        cambio.setValorAntiguo("Anterior");
        cambio.setValorNuevo(nuevoEstado);
        cambio.setEvento(evento);

        evento.setCambios(List.of(cambio));

        return eventoRepo.save(evento);
    }
    
    
    /*Convertir de H2 a DTO*/
    
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