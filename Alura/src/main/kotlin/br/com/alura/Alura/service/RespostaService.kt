package br.com.alura.Alura.service

import br.com.alura.Alura.dto.NovaRespostaForm
import br.com.alura.Alura.dto.RespostaView
import br.com.alura.Alura.exception.NotFoundException
import br.com.alura.Alura.mapper.RespotaViewMapper
import br.com.alura.Alura.model.Resposta
import br.com.alura.Alura.repository.RespostaRepository
import br.com.alura.Alura.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class RespostaService (
    private val usuarioService: UsuarioService,
    private val repository: RespostaRepository,
    private val topicoRepository: TopicoRepository,
    private val respostaViewMapper: RespotaViewMapper
    ) {

    fun listar(): List<RespostaView> {
        val respostas = repository.findAll();

        return respostas.map{t ->
            respostaViewMapper.map(t)
        }
    }
    fun listarPorId(id: Long): Optional<Resposta> {
        return repository.findById(id)
    }
    fun cadastrar(novaRespostaForm: NovaRespostaForm): RespostaView {

        val novaResposta = Resposta(
            mensagem = novaRespostaForm.mensagem,
            autor = usuarioService.buscarPorId(novaRespostaForm.idAutor),
            topico = topicoRepository.getById(novaRespostaForm.idTopico),
            solucao = false
        )
        repository.save(novaResposta)
        return respostaViewMapper.map(novaResposta)
    }

    fun editar(id: Long, mensagem: String) {

    }

    fun deletar(id: Long){
        repository.findById(id).orElseThrow { NotFoundException("Resposta não encontrada") }
        return repository.deleteById(id)
    }




}


