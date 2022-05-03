package br.com.alura.Alura.Repository

import br.com.alura.Alura.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long> {
}