package ru.mdpetrenko.testtasks.hotels

class SearchController {
    HotelService hotelService
    CountryService countryService

    def index() {
        respond (hotelsTotal: Hotel.count())
    }

    def search(String titlePart, String countryTitle) {
        def hotels = countryTitle != ''
                ? hotelService.findAllByTitleIlikeAndCountry('%' + titlePart + '%', countryService.findByTitle(countryTitle))
                : hotelService.findAllByTitleIlike('%' + titlePart + '%')
        respond hotels, model: [hotelCount: hotels.size()]
    }

}
