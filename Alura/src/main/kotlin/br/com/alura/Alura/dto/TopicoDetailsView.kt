package br.com.alura.Alura.dto

import br.com.alura.Alura.model.Curso
import br.com.alura.Alura.model.StatusTopico
import br.com.alura.Alura.model.Usuario
import java.time.LocalDate
import java.time.LocalDateTime


data class TopicoDetailsView (
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val curso: Curso,
    val autor: Usuario,
    var status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    var dataEdicao: LocalDate? = null
)