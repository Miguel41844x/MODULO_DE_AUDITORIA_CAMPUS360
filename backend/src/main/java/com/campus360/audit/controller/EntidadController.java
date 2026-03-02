package com.campus360.audit.controller;

import org.springframework.web.bind.annotation.*;
import com.campus360.audit.domain.Entidad;
import com.campus360.audit.repository.EntidadRepository;

import java.util.List;

@RestController
@RequestMapping("/api/entidades")
@CrossOrigin(origins = "*")
public class EntidadController {

    private final EntidadRepository entidadRepo;

    public EntidadController(EntidadRepository entidadRepo) {
        this.entidadRepo = entidadRepo;
    }

    @PostMapping
    public Entidad crearEntidad(@RequestBody Entidad entidad) {
        return entidadRepo.save(entidad);
    }

    @GetMapping
    public List<Entidad> listarEntidades() {
        return entidadRepo.findAll();
    }

    @GetMapping("/{id}")
    public Entidad obtenerEntidad(@PathVariable Long id) {
        return entidadRepo.findById(id).orElse(null);
    }
}