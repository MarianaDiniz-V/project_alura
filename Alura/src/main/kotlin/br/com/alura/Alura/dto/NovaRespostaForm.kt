package br.com.alura.Alura.dto

import java.time.LocalDate
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NovaRespostaForm (
    val mensagem: String,
    val idAutor : Long,
    val idTopico: Long
    )