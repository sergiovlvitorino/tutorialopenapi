package br.com.vitorino.tutorialopenapi.person

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/v1/people")
@Validated
class PersonRestController(private val service: PersonServiceImpl) {

    private val log = LoggerFactory.getLogger(PersonRestController::class.java)

    @Operation(description = "save new person")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "armazena uma nova pessoa"),
            ApiResponse(responseCode = "400", description = "dados informados para a pessoa estao invalidos"),
            ApiResponse(responseCode = "500", description = "erro interno"),
        ]
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun save(@RequestBody @Valid request: PersonSaveRequest): ResponseEntity<PersonResponse> {
        log.info("Payload recebido com sucesso {}", request)
        val personResult = service.save(request.mapToPerson())
        return ResponseEntity(PersonResponse.mapToResponse(personResult), HttpStatus.CREATED)
    }

    @Operation(description = "list all people")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "lista todas as pessoas"),
            ApiResponse(responseCode = "500", description = "erro interno"),
        ]
    )
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun list() = service.findAll().stream().map { person -> PersonResponse.mapToResponse(person) }.collect(Collectors.toList())

}