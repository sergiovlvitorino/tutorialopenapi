package br.com.vitorino.tutorialopenapi.person

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

class PersonSaveRequest(

    @Size(min = 5, max = 10)
    @NotBlank
    var name: String,

    @Min(0)
    @Max(200)

    var age: Int
) {
    fun mapToPerson() = Person(
        id = null,
        name = this.name,
        age = this.age
    )
}