package br.com.vitorino.tutorialopenapi.person

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PersonServiceImpl: PersonService {

    private val log = LoggerFactory.getLogger(PersonServiceImpl::class.java)
    companion object{
        private val PEOPLE = mutableListOf<Person>()
    }

    override fun save(person: Person): Person {
        person.id = UUID.randomUUID().toString()
        log.info("Pessoa gravada com sucesso {}", person)
        PEOPLE.add(person)
        return person
    }

    override fun findAll() = PEOPLE

}