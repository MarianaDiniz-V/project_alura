package br.com.alura.Alura.controller

import br.com.alura.Alura.Dto.NovoTopico
import br.com.alura.Alura.model.*
import br.com.alura.Alura.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController (private val service: TopicoService) {

    @GetMapping
    fun listar(): List<Topico> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun listarPorId(@PathVariable id: Long): Topico {
        return service.listarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody dto: NovoTopico) {
        service.cadastrar(dto)
        return
    }

}