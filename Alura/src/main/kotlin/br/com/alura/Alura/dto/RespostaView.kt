package br.com.alura.Alura.dto

import java.time.LocalDateTime

data class RespostaView(
    val mensagem: String,
    val dataCriacao: LocalDateTime,
    val autor: String,
    val topico: String,
    val solucao: Boolean
        )