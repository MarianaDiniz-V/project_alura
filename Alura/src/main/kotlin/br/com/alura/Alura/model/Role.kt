package br.com.alura.Alura.model

import org.springframework.security.core.GrantedAuthority
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Role(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id:Long,
    private  val nome: String
) : GrantedAuthority {
    // "GrantedAuthority" é o retorno cobrado pelo método "getAuthorities" em "UserDetail"
    override fun getAuthority() = nome
    // Ao devolver a role, traga o nome
}

// A role é a tabela que contém as autorizações que o usuário pode ter.
//Para ligar uma role a um usuário criamos uma tabela intermediária
//(usuario 1 tem a role 1, usuario 1 tem a role 2...)