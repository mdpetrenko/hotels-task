package ru.mdpetrenko.testtasks.hotels

import grails.gorm.services.Service

@Service(Country)
interface CountryService {

    Country get(Serializable id)

    List<Country> list(Map args)

    Long count()

    void delete(Serializable id)

    Country save(Country country)

    Country findByTitle(String title)

}