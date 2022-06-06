package br.com.alura.Alura.repository

import br.com.alura.Alura.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {
    fun findByCursoNome(nomeCurso: String, pageable: org.springframework.data.domain.Pageable): Page<Topico>
}