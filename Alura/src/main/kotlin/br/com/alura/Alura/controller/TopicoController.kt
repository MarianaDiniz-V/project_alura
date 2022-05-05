package br.com.alura.Alura.controller

import br.com.alura.Alura.Dto.NovoTopicoForm
import br.com.alura.Alura.Dto.TopicoView
import br.com.alura.Alura.Dto.UpdateTopicoForm
import br.com.alura.Alura.model.*
import br.com.alura.Alura.service.TopicoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.transaction.Transactional
import javax.validation.Valid
import org.springframework.data.domain.Sort

@RestController
@RequestMapping("/topicos")
class TopicoController (private val service: TopicoService) {

    @GetMapping
    fun listar(
        @PageableDefault(
            size = 3,
            sort = ["dataCriacao"],
            direction = org.springframework.data.domain.Sort.Direction.DESC) paginacao: Pageable
    ): Page<TopicoView> {
        return service.listar(paginacao)
    }

    @GetMapping("/{id}")
    fun listarPorId(@PathVariable id: Long): Topico {
        return service.listarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: NovoTopicoForm) : TopicoView {
        return service.cadastrar(dto)
    }

    @PutMapping
    @Transactional
    fun editar(@RequestBody @Valid dto: UpdateTopicoForm) {
        return service.editar(dto)
    }

    @Transactional
    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long){
        return service.deletar(id)
    }
}