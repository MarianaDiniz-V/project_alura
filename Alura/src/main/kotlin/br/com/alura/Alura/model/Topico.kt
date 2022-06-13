package br.com.alura.Alura.model

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*
@Entity
data class Topico (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var titulo: String,
    var mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val curso: Curso,
    @ManyToOne
    val autor: Usuario,
    @Enumerated(value = EnumType.STRING)
    var status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    @OneToMany(mappedBy = "topico")
    //Na classe resposta também possui o tópico
    var respostas: MutableList<Resposta> = ArrayList(),
    var dataEdicao: LocalDate? = null
        )