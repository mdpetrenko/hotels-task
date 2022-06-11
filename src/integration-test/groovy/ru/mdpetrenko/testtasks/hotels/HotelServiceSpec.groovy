package ru.mdpetrenko.testtasks.hotels

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class HotelServiceSpec extends Specification {

    HotelService hotelService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        Country testCountry = new Country(title: 'Country', capital: 'Capital')
        new Hotel(title: 'Hotel 1', stars: Hotel.Stars.ONE, country: testCountry).save(flush: true, failOnError: true)
        new Hotel(title: 'Hotel 2', stars: Hotel.Stars.TWO, country: testCountry, site: 'http://test.site').save(flush: true, failOnError: true)
        Hotel hotel = new Hotel(title: 'Hotel 3', stars: Hotel.Stars.THREE, country: testCountry, site: 'http://test.site').save(flush: true, failOnError: true)
        new Hotel(title: 'Hotel 4', stars: Hotel.Stars.FOUR, country: testCountry, site: 'http://test.site').save(flush: true, failOnError: true)
        new Hotel(title: 'Hotel 5', stars: Hotel.Stars.FIVE, country: testCountry, site: 'http://test.site').save(flush: true, failOnError: true)
        hotel.id
    }

    void "test get"() {
        setupData()

        expect:
        hotelService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Hotel> hotelList = hotelService.list(max: 2, offset: 2)

        then:
        hotelList.size() == 2
        hotelList.get(0).getId() == 8
    }

    void "test count"() {
        setupData()

        expect:
        hotelService.count() == 5
    }

    void "test delete"() {
        Long hotelId = setupData()

        expect:
        hotelService.count() == 5

        when:
        hotelService.delete(hotelId)
        sessionFactory.currentSession.flush()

        then:
        hotelService.count() == 4
    }

    void "test save"() {
        when:
        Country country = new Country(title: 'Country Save Test', capital: 'Capital')
        Hotel hotel = new Hotel(title: 'Hotel Title', stars: Hotel.Stars.FIVE, country: country)
        Hotel secondHotel = new Hotel(title: 'Second Hotel Title', stars: Hotel.Stars.FIVE, country: country, site: 'http://test.site')
        hotelService.save(hotel)
        hotelService.save(secondHotel)
        then:
        hotel.id != null
        secondHotel.id != null
    }
}
