package br.com.alura.Alura.repository

import br.com.alura.Alura.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long> {

    fun findByEmail(username: String?) : Usuario?
}