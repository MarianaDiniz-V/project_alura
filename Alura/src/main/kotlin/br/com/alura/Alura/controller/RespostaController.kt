package br.com.alura.Alura.controller

import br.com.alura.Alura.dto.NovaRespostaForm
import br.com.alura.Alura.dto.RespostaView
import br.com.alura.Alura.model.Resposta
import br.com.alura.Alura.service.RespostaService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.transaction.Transactional

@RestController
@RequestMapping("/respostas")
class RespostaController(private val service: RespostaService) {

    @GetMapping
    fun listar(): List<RespostaView> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun listar(@PathVariable id: Long): Optional<Resposta> {
        return service.listarPorId(id)
    }

    @Transactional
    @PostMapping
    fun cadastrar (
        @RequestBody novaRespostaForm: NovaRespostaForm): RespostaView {
        val novaResposta = novaRespostaForm
        return service.cadastrar(novaResposta)
    }
    @Transactional
    @PutMapping("/{id}")
    fun editar(
        @PathVariable id: Long,
        @RequestBody mensagem: String){
        return service.editar(id,mensagem)

    }

    @Transactional
    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long){
        return service.deletar(id)
    }
}