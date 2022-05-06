package br.com.alura.Alura.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Usuario  (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val email: String,
    val password: String,
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    //ao trazer o usuário trás também tudo ligado a ele(roles)
    @JoinColumn(name = "usuario_role")
    val role: List<Role> = mutableListOf()
    )