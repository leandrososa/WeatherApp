package com.leandrososa.weatherapp.components

import androidx.lifecycle.ViewModel

class CityListViewModel: ViewModel() {
    fun getFlagEmoji(countryCode: String): String {
        return countryCode.uppercase().map { c ->
            val flagOffset = c.code - 'A'.code + 0x1F1E6
            Character.toChars(flagOffset)
        }.joinToString(separator = "")
    }
}