package ru.mdpetrenko.testtasks.hotels

class Country {
    String title
    String capital

    static constraints = {
        title maxSize: 255, unique: true, nullable: false
        capital maxSize: 128, nullable: false
    }

    String toString() {
        title
    }

}
