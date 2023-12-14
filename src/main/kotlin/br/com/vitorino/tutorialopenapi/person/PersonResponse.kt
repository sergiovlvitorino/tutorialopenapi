package br.com.vitorino.tutorialopenapi.person

data class PersonResponse(var id: String, var name: String, var age: Int) {
    companion object{
        fun mapToResponse(person: Person) = PersonResponse(
            id = requireNotNull(person.id),
            name = person.name,
            age = person.age
        )
    }
}