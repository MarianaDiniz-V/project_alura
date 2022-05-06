package br.com.alura.Alura.repository

import br.com.alura.Alura.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository: JpaRepository<Curso, Long>{
}