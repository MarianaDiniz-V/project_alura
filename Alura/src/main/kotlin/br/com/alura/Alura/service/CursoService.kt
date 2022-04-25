package br.com.alura.Alura.service

import br.com.alura.Alura.model.Curso
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(private var cursos : List<Curso> = listOf()) {
    init {
        val curso1 = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programação"
        )
        val curso2 = Curso(
            id = 2,
            nome = "Java",
            categoria = "Programação"
        )
        val curso3 = Curso(
            id = 3,
            nome = "Angular",
            categoria = "Programação"
        )

        cursos = Arrays.asList(curso1, curso2, curso3)
    }

    fun buscarPorId(id: Long): Curso {
        return cursos.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }
}