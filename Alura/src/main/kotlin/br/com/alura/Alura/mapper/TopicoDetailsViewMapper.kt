package br.com.alura.Alura.mapper

import br.com.alura.Alura.dto.TopicoDetailsView
import br.com.alura.Alura.model.Topico

class TopicoDetailsViewMapper : Mapper<Topico, TopicoDetailsView> {
    override fun map(t: Topico): TopicoDetailsView {
        return TopicoDetailsView(
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            curso = t.curso,
            autor = t.autor,
            status = t.status,
            dataEdicao = t.dataEdicao
        )
    }
}