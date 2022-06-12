package ru.mdpetrenko.testtasks.hotels

class HomeController {

    def index() {
        respond(hotelsTotal: Hotel.count())
    }

}
