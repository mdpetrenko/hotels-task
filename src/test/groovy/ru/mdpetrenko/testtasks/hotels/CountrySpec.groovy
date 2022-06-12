package ru.mdpetrenko.testtasks.hotels

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.lang.Subject


class CountrySpec extends Specification implements DomainUnitTest<Country> {

    @Subject
    Country country

    def setup() {
        country = new Country()
    }

    def cleanup() {
    }

    void 'test country title cannot be null'() {
        when:
        country.title = null

        then:
        !country.validate(['title'])
        country.errors['title'].code == 'nullable'
    }

    void 'test country title cannot be blank'() {
        when:
        country.title = ''

        then:
        !country.validate(['title'])
    }

    void 'test country title maxSize 255'() {
        when:
        country.title = 'c' * 256

        then:
        !country.validate(['title'])
        country.errors['title'].code == 'maxSize.exceeded'

        when: 'correct title'
        country.title = 'c' * 255

        then:
        country.validate(['title'])
    }

    void 'test capital cannot be null'() {
        when:
        country.capital = null

        then:
        !country.validate(['capital'])
        country.errors['capital'].code == 'nullable'
    }

    void 'test capital cannot be blank'() {
        when:
        country.capital = ''

        then:
        !country.validate(['capital'])
    }

    void 'test capital maxSize 128'() {
        when:
        country.capital = 'c' * 129

        then:
        !country.validate(['capital'])
        country.errors['capital'].code == 'maxSize exceeded'

        when:
        country.capital = 'c' * 128

        then:
        country.validate(['capital'])
    }

}