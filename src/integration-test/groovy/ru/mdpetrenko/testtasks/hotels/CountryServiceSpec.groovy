package ru.mdpetrenko.testtasks.hotels

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
@Rollback
class CountryServiceSpec extends Specification {

    @Autowired
    CountryService countryService
    SessionFactory sessionFactory

    private Long setupData() {
        new Country(title: 'Country1', capital: 'Capital1').save(flush: true, failOnError: true)
        new Country(title: 'Country2', capital: 'Capital2').save(flush: true, failOnError: true)
        Country country = new Country(title: 'test3', capital: 'Capital3').save(flush: true, failOnError: true)
        new Country(title: 'Country3', capital: 'Capital4').save(flush: true, failOnError: true)
        new Country(title: 'Country4', capital: 'Capital5').save(flush: true, failOnError: true)
        country.id
    }

    void "test get"() {
        setupData()

        expect:
        countryService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Country> countryList = countryService.list(max: 2, offset: 2)

        then: 'Not empty list returned'
        countryList.size() == 2
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

        and:
        countryService.get(countryId) == null
    }

    void "test save"() {
        when:
        Country country = new Country(title: 'Country', capital: 'Capital')
        countryService.save(country)

        then:
        country.id != null
    }

}
