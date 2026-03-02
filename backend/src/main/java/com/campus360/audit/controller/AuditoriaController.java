package com.campus360.audit.controller;

import com.campus360.audit.dto.EventoExportDTO;
import com.campus360.audit.domain.EventoAuditoria;
import com.campus360.audit.service.AuditoriaService;
import com.campus360.audit.service.ExcelService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/auditoria")
@CrossOrigin
public class AuditoriaController {

    private final AuditoriaService service;
    private final ExcelService excelService;

    public AuditoriaController(AuditoriaService service,
                                ExcelService excelService) {
        this.service = service;
        this.excelService = excelService;
    }

    @GetMapping
    public List<EventoAuditoria> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/historial/{id}")
    public List<EventoAuditoria> historial(@PathVariable Long id) {
        return service.obtenerHistorial(id);
    }

    /*
     ESTE POST SIMULA QUE OTRO MODULO CAMBIÓ EL ESTADO
    */
    @PostMapping("/registrarCambio")
    public EventoAuditoria registrarCambio(
            @RequestParam Long idEntidad,
            @RequestParam String nuevoEstado,
            @RequestParam Long idUsuario) {

        return service.registrarCambioEstado(idEntidad, nuevoEstado, idUsuario);
    }

    @GetMapping("/exportar")
    public ResponseEntity<InputStreamResource> exportarExcel() throws IOException {

        List<EventoExportDTO> eventos = service.obtenerEventosParaExportar();

        ByteArrayInputStream in = excelService.exportarBitacora(eventos);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=bitacora.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }
    
    @PostMapping
    public EventoAuditoria crearEvento(@RequestBody EventoAuditoria evento) {
        return service.guardarEvento(evento);
    }
}