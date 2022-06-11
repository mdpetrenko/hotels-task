package ru.mdpetrenko.testtasks.hotels

import grails.gorm.services.Service

@Service(Hotel)
interface HotelService {

    Hotel get(Serializable id)

    List<Hotel> list(Map args)

    List<Hotel> findAllByTitleIlikeAndCountry(String title, Country country)

    List<Hotel> findAllByTitleIlike(String title)

    Long count()

    void delete(Serializable id)

    Hotel save(Hotel hotel)

    Hotel save(String title, Country country, Hotel.Stars stars, String site)

}