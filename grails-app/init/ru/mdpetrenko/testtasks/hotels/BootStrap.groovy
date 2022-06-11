package ru.mdpetrenko.testtasks.hotels

class BootStrap {
    HotelService hotelService

    def init = { servletContext ->
        Country russia = new Country(title: 'Russia', capital: 'Moscow').save()
        Country cyprus = new Country(title:  "Cyprus", capital:  'Pathos').save()
        Country germany = new Country(title:  'Germany', capital:  'Berlin').save()
        hotelService.save('Radisson', russia, Hotel.Stars.FOUR, null)
        hotelService.save('Hyatt', russia, Hotel.Stars.FIVE, 'https://www.hyatt.com/ru-RU/home')
        hotelService.save('Axel', russia, Hotel.Stars.TWO, 'https://www.hyatt.com/ru-RU/home')
        hotelService.save('Tsokkos', cyprus, Hotel.Stars.FOUR, 'https://www.tsokkos.com/')
        hotelService.save('Tsokkos Gardens', cyprus, Hotel.Stars.THREE, 'https://www.tsokkos.com/')
        hotelService.save('Leonardo Royal Hotel Frankfurt', germany, Hotel.Stars.FOUR, null)

    }
    def destroy = {
    }
}
