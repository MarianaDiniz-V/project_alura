package br.com.alura.Alura.controller

import br.com.alura.Alura.dto.NovoTopicoForm
import br.com.alura.Alura.dto.TopicoView
import br.com.alura.Alura.dto.UpdateTopicoForm
import br.com.alura.Alura.model.*
import br.com.alura.Alura.service.TopicoService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/topicos")
class TopicoController (private val service: TopicoService) {

    @GetMapping
    fun listar(
        @RequestParam(required = false) nomeCurso: String?,
        @PageableDefault(
            size = 3,
            sort = ["dataCriacao"],
            direction = org.springframework.data.domain.Sort.Direction.DESC) paginacao: Pageable
    ): Page<TopicoView> {
        return service.listar(nomeCurso, paginacao)
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