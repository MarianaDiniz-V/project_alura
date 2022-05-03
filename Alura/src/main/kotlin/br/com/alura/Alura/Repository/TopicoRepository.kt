package br.com.alura.Alura.Repository

import br.com.alura.Alura.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {
}