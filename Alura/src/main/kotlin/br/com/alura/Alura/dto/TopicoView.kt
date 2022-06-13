package br.com.alura.Alura.dto

import br.com.alura.Alura.model.StatusTopico
import java.time.LocalDate

data class TopicoView(
    val titulo: String,
    val curso: String,
    val autor: String,
    val dataEdicao: LocalDate?
)