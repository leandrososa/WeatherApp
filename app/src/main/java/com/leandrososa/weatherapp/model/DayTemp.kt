package com.leandrososa.weatherapp.model

class DayTemp {
    var dayName: DayName? = null
    var minTemp: Double = 0.0
    var maxTemp: Double = 0.0
}

enum class DayName {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}