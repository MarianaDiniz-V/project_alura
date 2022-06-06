package br.com.alura.Alura.models

import br.com.alura.Alura.model.Usuario

object UsuarioTest {

    fun build() : Usuario{
        return Usuario(
            id = 1,
            nome = "ana",
            email = "ana@email.com",
            password = "12345678",
        )
    }
}