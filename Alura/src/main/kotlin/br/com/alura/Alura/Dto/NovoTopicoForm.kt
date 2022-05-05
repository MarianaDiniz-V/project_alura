package br.com.alura.Alura.Dto

import br.com.alura.Alura.model.Topico
import br.com.alura.Alura.service.CursoService
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NovoTopicoForm (
    @field:NotEmpty @field:Size(min = 6, max = 20) val titulo: String,
    @field: NotEmpty
    val mensagem: String,
    @field:NotNull
    val idCurso: Long,
    @field:NotNull
    val idAutor: Long,
)