package br.com.alura.Alura.models

import br.com.alura.Alura.model.*
import java.time.LocalDate
import java.time.LocalDateTime

object TopicoTest {
    fun build() = Topico(
            id = 1,
            titulo = "Kotlin",
            mensagem = "Como percorrer um array?",
            curso = CursoTest.build(),
            autor = UsuarioTest.build()
        )
}