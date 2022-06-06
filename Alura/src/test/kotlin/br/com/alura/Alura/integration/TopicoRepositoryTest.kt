package br.com.alura.Alura.integration

import br.com.alura.Alura.model.Topico
import br.com.alura.Alura.models.TopicoTest
import br.com.alura.Alura.repository.TopicoRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TopicoRepositoryTest {

    @Autowired
    private lateinit var topicoRepository: TopicoRepository
    private val topico = TopicoTest.build()
    private val pageable = PageRequest.of(0,5)

    companion object{
        @Container
        private val mysqlContainer = MySQLContainer<Nothing>(
            "mysql:8.0.28"
        ).
                apply {
                    withDatabaseName("testedb")
                    withUsername("mari")
                    withPassword("123456")
                }
        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry){
            registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl)
            registry.add("spring.datasource.password", mysqlContainer::getPassword)
            registry.add("spring.datasource.username", mysqlContainer::getUsername)
        }
    }
    @Test
    fun `deve retornar um tópico através do nome do curso`(){
        topicoRepository.save(topico)
        val topicoByCursoNome = topicoRepository.findByCursoNome("Kotlin", pageable)

        assertThat(topicoByCursoNome.totalElements).isEqualTo(1)
    }
}