package ru.mdpetrenko.testtasks.hotels

import grails.util.Environment

class BootStrap {
    HotelService hotelService

    def init = { servletContext ->
        if (Environment.current == Environment.DEVELOPMENT) {
            Country russia = new Country(title: 'Россия', capital: 'Москва').save()
            Country cyprus = new Country(title: "Кипр", capital: 'Пафос').save()
            Country germany = new Country(title: 'Германия', capital: 'Берлин').save()
            hotelService.save('Radisson', russia, Hotel.Stars.FOUR, null)
            hotelService.save('Hyatt', russia, Hotel.Stars.FIVE, 'https://www.hyatt.com/ru-RU/home')
            hotelService.save('Axel', russia, Hotel.Stars.TWO, 'https://www.hyatt.com/ru-RU/home')
            hotelService.save('Tsokkos', cyprus, Hotel.Stars.FOUR, 'https://www.tsokkos.com/')
            hotelService.save('Tsokkos Gardens', cyprus, Hotel.Stars.THREE, 'https://www.tsokkos.com/')
            hotelService.save('Leonardo Royal Hotel Frankfurt', germany, Hotel.Stars.FOUR, null)
        }

    }
    def destroy = {
    }
}
