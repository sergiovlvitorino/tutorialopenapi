package br.com.vitorino.tutorialopenapi

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(info = Info(description = "api created with the intention to save people data"))
class TutorialopenapiApplication

fun main(args: Array<String>) {
	runApplication<TutorialopenapiApplication>(*args)
}
