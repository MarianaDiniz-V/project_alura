package br.com.alura.Alura.service

import br.com.alura.Alura.dto.TopicoViewTest
import br.com.alura.Alura.exception.NotFoundException
import br.com.alura.Alura.mapper.NovoTopicoFormMapper
import br.com.alura.Alura.mapper.TopicoViewMapper
import br.com.alura.Alura.models.TopicoTest
import br.com.alura.Alura.repository.TopicoRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*

class TopicoServiceTest {
    private val topico = TopicoTest.build()

    private val pageable: Pageable = mockk()
    private val pages = PageImpl(listOf(topico))

    private val topicoViewMapper: TopicoViewMapper = mockk()
    private val novoTopicoFormMapper: NovoTopicoFormMapper = mockk()

    private val repository: TopicoRepository = mockk{
        every { findAll(pageable) } returns pages
        every {findByCursoNome(any(), any())} returns pages
        every { topicoViewMapper.map(any()) } returns TopicoViewTest.buil()
    }

    private val topicoService = TopicoService(
        repository, novoTopicoFormMapper, topicoViewMapper
    )


    @Test
    fun `retorna todos os tópicos se o nome do curso for nulo`(){
        topicoService.listar(null, pageable)

        verify(exactly = 1) { repository.findAll(pageable) }
        verify(exactly = 0) { repository.findByCursoNome(any(), pageable) }
        verify(exactly = 1) { topicoViewMapper.map(any()) }
    }

    @Test
    fun `retorna tópicos de um curso específico`(){
        topicoService.listar("Kotlin Básico", pageable)

        verify(exactly = 0) { repository.findAll(pageable) }
        verify(exactly = 1) { repository.findByCursoNome(any(), pageable) }
        verify(exactly = 1) { topicoViewMapper.map(any()) }
    }

    @Test
    fun `retorna not found quando nenhum tópico é encontrado`(){
        every { repository.findById(any()) } returns  Optional.empty()

        val atual = assertThrows<NotFoundException> {
            topicoService.listarPorId(4)
        }

        assertThat(atual.message).isEqualTo("Tópico não encontrado")

    }



}

