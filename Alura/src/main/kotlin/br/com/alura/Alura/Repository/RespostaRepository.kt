package br.com.alura.Alura.Repository

import br.com.alura.Alura.model.Resposta
import org.springframework.data.jpa.repository.JpaRepository

interface RespostaRepository: JpaRepository<Resposta, Long>{
}