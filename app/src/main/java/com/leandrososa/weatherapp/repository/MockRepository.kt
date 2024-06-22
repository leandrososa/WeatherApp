package com.leandrososa.weatherapp.repository

import com.leandrososa.weatherapp.model.CityInfo
import com.leandrososa.weatherapp.model.Clouds
import com.leandrososa.weatherapp.model.Coord
import com.leandrososa.weatherapp.model.DayWeather
import com.leandrososa.weatherapp.model.ForecastResponse
import com.leandrososa.weatherapp.model.ForecastSys
import com.leandrososa.weatherapp.model.Place
import com.leandrososa.weatherapp.model.SearchResponse
import com.leandrososa.weatherapp.model.WeatherDesc
import com.leandrososa.weatherapp.model.WeatherMain
import com.leandrososa.weatherapp.model.WeatherResponse
import com.leandrososa.weatherapp.model.WeatherSys
import com.leandrososa.weatherapp.model.Wind
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MockRepository: IRepository {
    override suspend fun search(cityName: String): SearchResponse {
        withContext(Dispatchers.IO) {
            Thread.sleep(1000)
        }
        return SearchResponse(
            listOf(
                Place(
                    "Cordoba",
                    mapOf("es" to "Córdoba"),
                    -31.4173391f,
                    -64.183319f,
                    "AR",
                    "Cordoba"
                ),
                Place(
                    "Cordoba",
                    mapOf("es" to "Córdoba"),
                    37.8845813f,
                    -4.7760138f,
                    "ES",
                    "Andalusia",
                ),
                Place(
                    "Córdoba",
                    null,
                    37.8845813f,
                    -4.7760138f,
                    "MX",
                    "Veracruz"
                )
            )
        )
    }

    override suspend fun getWeather(coord: Coord): WeatherResponse {
        withContext(Dispatchers.IO) {
            Thread.sleep(1000)
        }
        return WeatherResponse(
            Coord((-31.4173).toFloat(), (-64.1833).toFloat()),
            listOf(
                WeatherDesc(
                    800,
                    "Clear",
                    "clear sky",
                    "01d"
                )
            ),
            "stations",
            WeatherMain(
                23.43,
                22.64,
                18.87,
                23.43,
                1012,
                1012,
                955,
                31,
                4.56
            ),
            10000,
            Wind(2.09, 101,2.09),
            Clouds(0),
            1717275600,
            WeatherSys(1, 8233, "AR", 1717240083, 1717276896),
            -10800,
            3860259,
            "Córdoba",
            200
        )
    }
    override suspend fun getForecast(coord: Coord): ForecastResponse {
        withContext(Dispatchers.IO) {
            Thread.sleep(1000)
        }
        return ForecastResponse(
            "200",
            0,
            7,
            listOf(
                DayWeather(
                    1717275600,
                    WeatherMain(
                        23.43,
                        22.64,
                        18.87,
                        23.43,
                        1012,
                        1012,
                        955,
                        31,
                        4.56
                    ),
                    listOf(
                        WeatherDesc(
                            800,
                            "Clear",
                            "clear sky",
                            "01d"
                        )
                    ),
                    Clouds(0),
                    Wind(2.09, 101,2.09),
                    10000,
                    0.0,
                    ForecastSys("d"),
                    "2024-06-01 21:00:00"
                ),
                DayWeather(
                    1717286400,
                    WeatherMain(
                        20.42,
                        19.56,
                        14.39,
                        20.42,
                        1012,
                        1012,
                        956,
                        40,
                        6.03
                    ),
                    listOf(
                        WeatherDesc(
                            800,
                            "Clear",
                            "clear sky",
                            "01d"
                        )
                    ),
                    Clouds(1),
                    Wind(0.21, 208,0.6),
                    10000,
                    0.0,
                    ForecastSys("n"),
                    "2024-06-02 00:00:00"
                ),
                DayWeather(
                    1717297200,
                    WeatherMain(
                        17.89,
                        17.02,
                        12.89,
                        17.89,
                        1013,
                        1013,
                        956,
                        50,
                        5.02
                    ),
                    listOf(
                        WeatherDesc(
                            800,
                            "Clear",
                            "clear sky",
                            "01d"
                        )
                    ),
                    Clouds(0),
                    Wind(0.21, 208,0.6),
                    10000,
                    0.0,
                    ForecastSys("n"),
                    "2024-06-02 03:00:00"
                ),
            ),
            CityInfo(
                3860259,
                "Córdoba",
                Coord((-31.4173).toFloat(), (-64.1833).toFloat()),
                "AR",
                1428214,
                -10800,
                1717240083,
                1717276896
            )
        )
    }
}