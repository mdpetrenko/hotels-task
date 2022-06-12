package ru.mdpetrenko.testtasks.hotels

import grails.test.hibernate.HibernateSpec


class CountryUniqueTitleConstraintSpec extends HibernateSpec {

    List<Class> getDomainClasses() {[Country]}

    def 'test country title unique'() {
        when: 'valid country title provided'
        def country = new Country(title: 'Country', capital: 'Capital')

        then:
        country.validate()

        and:
        country.save()

        and:
        Country.count() == old(Country.count()) + 1

        when: 'duplicate country added'
        def duplicateCountry = new Country(title: 'Country', capital: 'Capital')

        then:
        !duplicateCountry.validate(['title'])

        and:
        duplicateCountry.errors['title']?.code == 'unique'

        and:
        !duplicateCountry.save()

        and:
        Country.count() == old(Country.count())
    }

}