package br.com.alura.Alura.mapper

import br.com.alura.Alura.Dto.TopicoView
import br.com.alura.Alura.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper: br.com.alura.Alura.mapper.Mapper<Topico, TopicoView> {
    override fun map(t: Topico): TopicoView {
       return TopicoView(
           titulo = t.titulo,
           curso = t.curso.nome,
           autor = t.autor.nome
       )
    }
}