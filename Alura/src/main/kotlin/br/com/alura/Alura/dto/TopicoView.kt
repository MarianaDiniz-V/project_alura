package br.com.alura.Alura.dto

import java.time.LocalDate

data class TopicoView(
    val titulo: String,
    val curso: String,
    val autor: String,
    val dataEdicao: LocalDate?
)