package ru.mdpetrenko.testtasks.hotels

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.annotation.DirtiesContext
import spock.lang.Specification

@Integration
//@Rollback
class CountryServiceSpec extends Specification {

    @Autowired
    CountryService countryService
    SessionFactory sessionFactory

    private Long setupData() {
        hotels.each { it.delete(flush: true, failOnError: true) }
        Country.findAll().each { it.delete(flush: true, failOnError: true) }
        new Country(title: 'test1', capital: 'Moscow').save(flush: true, failOnError: true)
        new Country(title: 'test2', capital: 'Berlin').save(flush: true, failOnError: true)
        Country country = new Country(title: 'test3', capital: 'Pathos').save(flush: true, failOnError: true)
        new Country(title: 'test4', capital: 'Paris').save(flush: true, failOnError: true)
        new Country(title: 'test5', capital: 'Madrid').save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        country.id
    }

    @DirtiesContext
    void "test get"() {
        setupData()

        expect:
        Country.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Country> countryList = countryService.list(max: 2, offset: 2)

        then:
        countryList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        countryService.count() == 5
    }

    void "test delete"() {
        Long countryId = setupData()

        expect:
        countryService.count() == 5

        when:
        countryService.delete(countryId)
        sessionFactory.currentSession.flush()

        then:
        countryService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Country country = new Country()
        countryService.save(country)

        then:
        country.id != null
    }
}
