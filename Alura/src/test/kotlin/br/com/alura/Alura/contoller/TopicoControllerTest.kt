package br.com.alura.Alura.contoller

import br.com.alura.Alura.config.JWTUtil
import br.com.alura.Alura.model.Role
import br.com.alura.Alura.models.UsuarioTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TopicoControllerTest {

    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext

    @Autowired
    private lateinit var jwtUtil: JWTUtil

    private lateinit var mockMvc: MockMvc

    private var token: String? = null

    companion object{
        private const val URI = "/topicos/"
    }

    @BeforeEach
    fun setup(){
        token = generateToken()
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).
                apply<DefaultMockMvcBuilder?>(
                    SecurityMockMvcConfigurers.springSecurity()
                ).build()
    }


    @Test
    fun `deve retornar código 400 ao fazer requisição sem token`(){
        mockMvc.get(URI).andExpect { status { is4xxClientError() } }
    }

    @Test
    fun `deve retornar código 200 ao fazer requisição autenticado`(){
        mockMvc.get(URI){
            headers { token?.let { this.setBearerAuth(it) } }
        }.andExpect { status { is2xxSuccessful() } }
    }

    private fun generateToken(): String? {
        val authorities = mutableListOf(Role(1, "LEITURA"))
        return jwtUtil.generateToken("gabiru@email.com", authorities)
    }
}