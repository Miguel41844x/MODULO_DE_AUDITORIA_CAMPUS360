package com.campus360.audit.service;

import com.campus360.audit.domain.*;
import com.campus360.audit.dto.EventoExportDTO;
import com.campus360.audit.repository.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuditoriaServiceTest {

    private EventoAuditoriaRepository eventoRepo;
    private EntidadRepository entidadRepo;
    private UsuarioRepository usuarioRepo;

    private AuditoriaService service;

    @BeforeEach
    void setUp() {
        eventoRepo = mock(EventoAuditoriaRepository.class);
        entidadRepo = mock(EntidadRepository.class);
        usuarioRepo = mock(UsuarioRepository.class);

        service = new AuditoriaService(eventoRepo, entidadRepo, usuarioRepo);
    }

    // 1 obtenerTodos()

    @Test
    void testObtenerTodos() {
        EventoAuditoria evento = new EventoAuditoria();
        evento.setAccion("CREAR");

        when(eventoRepo.findAll()).thenReturn(List.of(evento));

        List<EventoAuditoria> resultado = service.obtenerTodos();

        assertEquals(1, resultado.size());
        assertEquals("CREAR", resultado.get(0).getAccion());
    }

    // 2 obtenerHistorial()

    @Test
    void testObtenerHistorial() {
        EventoAuditoria evento = new EventoAuditoria();

        when(eventoRepo.findByEntidad_IdEntidad(1L))
                .thenReturn(List.of(evento));

        List<EventoAuditoria> resultado =
                service.obtenerHistorial(1L);

        assertEquals(1, resultado.size());
    }

    // 3 guardarEvento() correcto

    @Test
    void testGuardarEventoCorrecto() {

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1L);

        Entidad entidad = new Entidad();
        entidad.setIdEntidad(1L);

        EventoAuditoria evento = new EventoAuditoria();
        evento.setUsuario(usuario);
        evento.setEntidad(entidad);

        when(usuarioRepo.findById(1L))
                .thenReturn(Optional.of(usuario));

        when(entidadRepo.findById(1L))
                .thenReturn(Optional.of(entidad));

        when(eventoRepo.save(any(EventoAuditoria.class)))
                .thenReturn(evento);

        EventoAuditoria resultado = service.guardarEvento(evento);

        assertNotNull(resultado);
        verify(eventoRepo, times(1)).save(evento);
    }

    // 4 guardarEvento() usuario no existe

    @Test
    void testGuardarEventoUsuarioNoExiste() {

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(99L);

        EventoAuditoria evento = new EventoAuditoria();
        evento.setUsuario(usuario);
        evento.setEntidad(new Entidad());

        when(usuarioRepo.findById(99L))
                .thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> service.guardarEvento(evento));

        assertEquals("Usuario no existe", ex.getMessage());
    }

    // 5 registrarCambioEstado()

    @Test
    void testRegistrarCambioEstado() {

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1L);

        Entidad entidad = new Entidad();
        entidad.setIdEntidad(1L);

        when(usuarioRepo.findById(1L))
                .thenReturn(Optional.of(usuario));

        when(entidadRepo.findById(1L))
                .thenReturn(Optional.of(entidad));

        when(eventoRepo.save(any(EventoAuditoria.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        EventoAuditoria resultado =
                service.registrarCambioEstado(1L, "APROBADO", 1L);

        assertEquals("CAMBIO_ESTADO", resultado.getAccion());
        assertEquals(1, resultado.getCambios().size());
        assertEquals("APROBADO",
                resultado.getCambios().get(0).getValorNuevo());
    }

    // 6 obtenerEventosParaExportar()

    @Test
    void testObtenerEventosParaExportar() {

        Usuario usuario = new Usuario();
        usuario.setNombre("Admin");
        usuario.setRol("ADMIN");

        Entidad entidad = new Entidad();
        entidad.setTipoEntidad("Curso");

        EventoAuditoria evento = new EventoAuditoria();
        evento.setIdEvento(1L);
        evento.setUsuario(usuario);
        evento.setEntidad(entidad);
        evento.setAccion("EDITAR");
        evento.setDescripcion("Modificación");

        when(eventoRepo.findAll()).thenReturn(List.of(evento));

        List<EventoExportDTO> resultado =
                service.obtenerEventosParaExportar();

        assertEquals(1, resultado.size());
        assertEquals("ADMIN", resultado.get(0).getRol());
        assertEquals("Curso", resultado.get(0).getEntidad());
    }
}