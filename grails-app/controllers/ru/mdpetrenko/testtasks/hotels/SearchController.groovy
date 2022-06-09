package ru.mdpetrenko.testtasks.hotels

class SearchController {

    def index() {
        respond (hotelsTotal: Hotel.count())
    }

}
