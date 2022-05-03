package br.com.alura.Alura.service

import br.com.alura.Alura.model.Curso
import br.com.alura.Alura.Repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository : CursoRepository) {
    fun buscarPorId(id: Long): Curso {
        return repository.getById(id)
    }
}