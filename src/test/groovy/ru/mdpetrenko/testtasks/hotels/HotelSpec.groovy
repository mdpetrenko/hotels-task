package ru.mdpetrenko.testtasks.hotels

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.lang.Subject

class HotelSpec extends Specification implements DomainUnitTest<Hotel> {

    @Subject
    Hotel hotel

    def setup() {
        hotel = new Hotel()
    }

    def cleanup() {
    }

    void 'test hotel title cannot be null()'() {
        when:
        hotel.title = null

        then:
        !hotel.validate(['title'])
        hotel.errors['title'].code == 'nullable'

    }

    void 'test hotel title cannot be blank'() {
        when:
        hotel.title = ''

        then:
        !hotel.validate(['title'])
    }

    void 'test hotel title maxSize 255'() {
        when:
        hotel.title = 'h' * 256

        then:
        !hotel.validate(['title'])
        hotel.errors['title'].code == 'maxSize.exceeded'

        when: 'correct title'
        hotel.title = 'h' * 255

        then:
        hotel.validate(['title'])
    }

    void 'test stars cannot be null'() {
        when:
        hotel.stars = null

        then:
        !hotel.validate(['stars'])
        hotel.errors['stars'].code == 'nullable'
    }

    void 'test site can be null'() {
        when:
        hotel.site = null

        then:
        hotel.validate(['site'])
    }

    void 'test hotel site must starts with http or https'() {
        when:
        hotel.site = 'invalidUrl'

        then:
        !hotel.validate(['site'])

        when:
        hotel.site = 'http://validUrl'

        then:
        hotel.validate()
    }

    void 'test hotel country cannot be null' () {
        when:
        hotel.country == null

        then:
        !hotel.validate(['country'])
        hotel.errors['country'].code == 'nullable'
    }
}
