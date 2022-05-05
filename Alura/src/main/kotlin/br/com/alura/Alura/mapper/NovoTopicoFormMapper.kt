package br.com.alura.Alura.mapper

import br.com.alura.Alura.Dto.NovoTopicoForm
import br.com.alura.Alura.model.Topico
import br.com.alura.Alura.service.CursoService
import br.com.alura.Alura.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class NovoTopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
): Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }
}