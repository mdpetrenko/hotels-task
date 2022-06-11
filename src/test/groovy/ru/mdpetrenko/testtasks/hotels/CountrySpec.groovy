package ru.mdpetrenko.testtasks.hotels

import grails.testing.gorm.DomainUnitTest
import grails.validation.ValidationException
import spock.lang.Specification

class CountrySpec extends Specification implements DomainUnitTest<Country> {

    def setup() {
    }

    def cleanup() {
    }

    void "test country name is too long"() {
        when: "Title length too long"
        StringBuilder sb = new StringBuilder();
        for (i in 0..<256) {
            sb.append("Country")
        }
        Country countryLongName = new Country(title: sb.toString(), capital: 'Capital')
        countryService.save(countryLongName)

        then: "Validation exception is expected"
        !domain.validate(['title'])
        domain.errors['title'].code == 'maxSize.exceeded'
    }

    void "test country name is blank"() {
        when: "Title is empty"
        Country countryEmptyName = new Country(title: '  ', capital: 'Capital')
        countryService.save(countryEmptyName)

        then: "Validation exception is expected"
        thrown(ValidationException)
    }

    void "test country name is null"() {
        when: "Title is null"
        Country countryNullName = new Country(capital: 'Capital')
        countryService.save(countryNullName)

        then: "Validation exception is expected"

        thrown(ValidationException)
    }

    void "capital is blank"() {
        when:
        Country country = new Country(title: 'Country')
        countryService.save(country)

        then:
        thrown(ValidationException)
    }

}
