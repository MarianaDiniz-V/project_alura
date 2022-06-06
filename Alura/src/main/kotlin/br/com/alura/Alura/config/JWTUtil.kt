package br.com.alura.Alura.config

import br.com.alura.Alura.model.Role
import br.com.alura.Alura.service.UsuarioService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*

@Component
class JWTUtil (
    private val usuarioService: UsuarioService
        ){

    private val expiration : Long = 1000000
    @Value("\${jwt.secret")
    private lateinit var secret : String
    //lateinit só é inicializado quando a função é chamada pela primeira vez.

    fun generateToken(username: String, authorities: List<Role>) : String? {
        return Jwts.builder().
        setSubject(username).
        claim("role", authorities). //é a identificação do usuário (normalmente id)
        setExpiration(Date(System.currentTimeMillis() + expiration)).
        signWith(SignatureAlgorithm.HS512, secret.toByteArray()).
            // definimos o tipo de secret que vai ser usado.
            // o secret é transformado em um array de bytes.
        compact()
    }

    fun isValid(jwt: String?): Boolean {
        return try {
            Jwts.parser().setSigningKey(secret.toByteArray()).parseClaimsJws(jwt)
            true
        } catch (e: java.lang.IllegalArgumentException){
            false
        }
        }

    fun getAuthentication(jwt: String?) : Authentication {
        val username = Jwts.parser().setSigningKey(secret.toByteArray()).parseClaimsJws(jwt).body.subject
        val user = usuarioService.loadUserByUsername(username)
        return UsernamePasswordAuthenticationToken(username, null, user.authorities)
    }
}