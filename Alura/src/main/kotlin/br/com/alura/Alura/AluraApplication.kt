package br.com.alura.Alura

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class AluraApplication

fun main(args: Array<String>) {
	runApplication<AluraApplication>(*args)
}
