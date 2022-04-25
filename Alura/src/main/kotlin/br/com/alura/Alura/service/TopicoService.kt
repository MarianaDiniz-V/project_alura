package br.com.alura.Alura.service

import br.com.alura.Alura.Dto.NovoTopico
import br.com.alura.Alura.model.Curso
import br.com.alura.Alura.model.Topico
import br.com.alura.Alura.model.Usuario
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import java.util.*

@Service
class TopicoService (private var topicos: List<Topico>){

    init {
        val topico = Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            mensagem = "listas em Kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "programação"
            ),
            autor = Usuario(
                id = 1,
                nome = "Gabriela Guimarães",
                email = "gabiguim@email.com"
            )
        )
        val topico2 = Topico(
            id = 2,
            titulo = "Duvida Java",
            mensagem = "listas em Java",
            curso = Curso(
                id = 1,
                nome = "Java",
                categoria = "programação"
            ),
            autor = Usuario(
                id = 1,
                nome = "Gabriela Guimarães",
                email = "gabiguim@email.com"
            )
        )
        val topico3 = Topico(
            id = 3,
            titulo = "Duvida Angular",
            mensagem = "Responsividade",
            curso = Curso(
                id = 1,
                nome = "Angular",
                categoria = "programação"
            ),
            autor = Usuario(
                id = 1,
                nome = "Gabriela Guimarães",
                email = "gabiguim@email.com"
            )
        )
        topicos = Arrays.asList(topico, topico2, topico3)
    }


    fun listar(): List<Topico>{
        return topicos
    }

    fun listarPorId(id: Long): Topico {
        return topicos.stream().filter({
            t -> t.id == id
        }).findFirst().get()
    }

    fun cadastrar(@RequestBody dto: NovoTopico){
        val novoTopico = Topico(
            id = topicos.size.toLong() + 1,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = CursoService.buscarPorId(dto.idCurso),
        )
    }
}