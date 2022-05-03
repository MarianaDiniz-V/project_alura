package br.com.alura.Alura.service

import br.com.alura.Alura.Dto.NovoTopicoForm
import br.com.alura.Alura.Dto.TopicoView
import br.com.alura.Alura.Dto.UpdateTopicoForm
import br.com.alura.Alura.exception.NotFoundException
import br.com.alura.Alura.mapper.TopicoViewMapper
import br.com.alura.Alura.model.*
import br.com.alura.Alura.Repository.CursoRepository
import br.com.alura.Alura.Repository.TopicoRepository
import br.com.alura.Alura.Repository.UsuarioRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import java.util.stream.Collectors
import javax.validation.Valid

@Service
class TopicoService (
    private val repository: TopicoRepository,
    private val cursoRepository: CursoRepository,
    private val usuarioRepository: UsuarioRepository,
    private var topicoViewMapper: TopicoViewMapper,
    private val messageNotFound: String = "Tópico não encontrado"
    ){

    fun listar(): List<TopicoView>{
        return repository.findAll().stream().map{t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun listarPorId(id: Long): Topico {
        return repository.getById(id)
    }

    fun cadastrar(@RequestBody @Valid dto: NovoTopicoForm): TopicoView{
        val novoTopico = Topico(
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = CursoService(cursoRepository).buscarPorId(dto.idCurso),
            autor = UsuarioService(usuarioRepository).buscarPorId(dto.idAutor)
        )
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