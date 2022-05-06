package br.com.alura.Alura.service

import br.com.alura.Alura.model.Usuario
import br.com.alura.Alura.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
data class UsuarioService (private val repository: UsuarioRepository) : UserDetailsService{

    fun buscarPorId(id: Long): Usuario {
        return repository.getById(id)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val usuario = repository.findByEmail(username)?: throw java.lang.RuntimeException()
        return UserDetail(usuario)
    }
}
