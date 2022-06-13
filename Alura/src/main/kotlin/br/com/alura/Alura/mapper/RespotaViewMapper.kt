package br.com.alura.Alura.mapper

import br.com.alura.Alura.dto.RespostaView
import br.com.alura.Alura.model.Resposta
import org.springframework.stereotype.Component

@Component
class RespotaViewMapper : Mapper<Resposta,RespostaView>{
    override fun map(t: Resposta): RespostaView {
        return RespostaView(
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            autor = t.autor.nome,
            topico = t.topico.titulo,
            solucao = t.solucao
        )
    }
}