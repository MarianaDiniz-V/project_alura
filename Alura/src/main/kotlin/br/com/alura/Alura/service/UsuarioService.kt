package br.com.alura.Alura.service

import br.com.alura.Alura.model.Usuario
import br.com.alura.Alura.Repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
data class UsuarioService (private val repository: UsuarioRepository){

    fun buscarPorId(id: Long): Usuario {
        return repository.getById(id)
    }
}
