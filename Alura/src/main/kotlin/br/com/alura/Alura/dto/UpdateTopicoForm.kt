package br.com.alura.Alura.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class UpdateTopicoForm (
    @field: NotNull
    val id: Long,
    @field: NotEmpty
    val titulo: String,
    @field: NotEmpty
    val mensagem: String
        )
