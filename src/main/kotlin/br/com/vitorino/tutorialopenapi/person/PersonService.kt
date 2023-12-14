package br.com.vitorino.tutorialopenapi.person

interface PersonService {

    fun save(person: Person): Person
    fun findAll(): List<Person>

}