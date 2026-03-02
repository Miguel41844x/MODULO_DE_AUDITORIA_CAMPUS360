package com.campus360.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.campus360.audit.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
