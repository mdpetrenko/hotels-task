package ru.mdpetrenko.testtasks.hotels

class BootStrap {
    CountryService countryService
    HotelService hotelService

    def init = { servletContext ->
        Country russia = countryService.save('Russia', 'Moscow')
        Country cyprus = countryService.save('Cyprus', 'Pathos')
        Country germany = countryService.save('Germany', 'Berlin')
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
