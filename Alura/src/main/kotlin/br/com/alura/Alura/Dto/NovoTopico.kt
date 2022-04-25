package br.com.alura.Alura.Dto

data class NovoTopico (
    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idAutor: Long,
)