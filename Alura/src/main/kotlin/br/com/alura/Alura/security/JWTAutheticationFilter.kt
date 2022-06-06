package br.com.alura.Alura.security

import br.com.alura.Alura.config.JWTUtil
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAutheticationFilter(
    private val jwtUtil: JWTUtil
    ) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = request.getHeader("Authorization")
        val jwt = getToknDetail(token)

        if(jwtUtil.isValid(jwt)){
           val authetication = jwtUtil.getAuthentication(jwt)
            SecurityContextHolder.getContext().authentication = authetication
        }
        filterChain.doFilter(request, response)
    }

    private fun getToknDetail(token: String?) : String? {
        return token?.let { jwt ->
            jwt.startsWith("Bearer ")
            jwt.substring(7, jwt.length)
        } ?: null
    }

}
