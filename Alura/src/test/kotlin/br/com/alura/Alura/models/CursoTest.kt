package br.com.alura.Alura.models

import br.com.alura.Alura.model.Curso

object CursoTest {
    fun build(): Curso {
        return Curso(
            id = 1,
            nome = "Kotlin Básico",
            categoria = "Programação"
        )
    }
}