package br.com.alura.Alura.controller

import br.com.alura.Alura.model.Curso
import br.com.alura.Alura.service.CursoService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.cache.annotation.Cacheable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/cursos")
class CursoController (private val service: CursoService) {

    @GetMapping
    @Cacheable("cursos")
    fun listar(): List<Curso> {
        return service.listar()
    }
    @GetMapping("/{id}")
    fun listarPorId(@PathVariable id: Long): Curso {
        return service.buscarPorId(id)
    }
}