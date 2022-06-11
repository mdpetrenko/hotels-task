package ru.mdpetrenko.testtasks.hotels

class HomeController {
    HotelService hotelService
    CountryService countryService

    def index() {
        respond (hotelsTotal: Hotel.count())
    }

    def search(String titlePart, String countryTitle) {
        def hotelList = countryTitle != ''
                ? hotelService.findAllByTitleIlikeAndCountry('%' + titlePart + '%', countryService.findByTitle(countryTitle))
                : hotelService.findAllByTitleIlike('%' + titlePart + '%')
        respond(hotelList: hotelList, hotelCount: hotelList.size())
    }

}
