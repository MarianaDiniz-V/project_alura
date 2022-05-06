package br.com.alura.Alura.service

import br.com.alura.Alura.dto.NovoTopicoForm
import br.com.alura.Alura.dto.TopicoView
import br.com.alura.Alura.dto.UpdateTopicoForm
import br.com.alura.Alura.exception.NotFoundException
import br.com.alura.Alura.mapper.TopicoViewMapper
import br.com.alura.Alura.model.*
import br.com.alura.Alura.repository.TopicoRepository
import br.com.alura.Alura.mapper.NovoTopicoFormMapper
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

@Service
class TopicoService (
    private val repository: TopicoRepository,
    private val novoTopicoFormMapper: NovoTopicoFormMapper,
    private val topicoViewMapper: TopicoViewMapper,
    private val messageNotFound: String = "Tópico não encontrado"
    ){

    fun listar(
        paginacao: org.springframework.data.domain.Pageable
    ): Page<TopicoView>{
        val topicos = repository.findAll(paginacao)
        return topicos.map{t ->
            topicoViewMapper.map(t)
        }
    }
    fun listarPorId(id: Long): Topico {
        return repository.getById(id)
    }

    fun cadastrar(@RequestBody @Valid dto: NovoTopicoForm): TopicoView{
        val novoTopico = novoTopicoFormMapper.map(dto)
        repository.save(novoTopico)
        return topicoViewMapper.map(novoTopico)
    }

    fun editar(@RequestBody @Valid dto: UpdateTopicoForm){
        val topico = repository.findById(dto.id).orElseThrow{NotFoundException(messageNotFound)}
        topico.titulo = dto.titulo
        topico.mensagem = dto.mensagem
    }

    fun deletar(id: Long){
        repository.deleteById(id)
    }
}