package ru.mdpetrenko.testtasks.hotels

class Country {
    String title
    String capital

    static mapping = {
        sort title: "asc"
    }

    static constraints = {
        title maxSize: 255, unique: true, nullable: false
        capital maxSize: 128, nullable: false
    }

    String toString() {
        title
    }

}
