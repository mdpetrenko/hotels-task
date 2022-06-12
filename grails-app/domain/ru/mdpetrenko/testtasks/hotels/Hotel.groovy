package ru.mdpetrenko.testtasks.hotels

class Hotel {
    enum Stars {
        ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5)

        int number

        Stars(int number) {
            this.number = number
        }

        String toString() {
            number
        }
    }

    String title
    Country country
    Stars stars
    String site

    static belongsTo = [country: Country]

    static constraints = {
        title maxSize: 255, unique: 'country', nullable: false
        site validator: {
            if (it != null && !it.startsWith("http://") && !it.startsWith("https://")) {
                return ['invalidUrl']
            }
        }, nullable: true, blank: true, url: true
    }

    static mapping = {
        stars(enumType: "ordinal")
        sort stars: "desc", title: "asc"
    }

    String toString() {
        title
    }
}
