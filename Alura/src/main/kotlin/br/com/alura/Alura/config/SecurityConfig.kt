package br.com.alura.Alura.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfig (
    private val userDetailsService: UserDetailsService
        ): WebSecurityConfigurerAdapter(){
    override fun configure(http: HttpSecurity?) {
        http?.
        authorizeRequests()?.
        antMatchers("/topicos")?.hasAnyAuthority("LEITURA")?.
        anyRequest()?.
        authenticated()?.
        and()?.
        sessionManagement()?.
        sessionCreationPolicy(SessionCreationPolicy.STATELESS)?.
            //não guarda o estado da aplicação
        and()?.
        formLogin()?.
        disable()?.
        httpBasic()
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder{
        return BCryptPasswordEncoder()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(userDetailsService)?.passwordEncoder(bCryptPasswordEncoder())
    }
}