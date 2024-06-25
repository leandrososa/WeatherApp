package com.leandrososa.weatherapp.view.weather.forecast

import android.icu.text.DecimalFormat
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leandrososa.weatherapp.model.Coord
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Forecast(
    modifier: Modifier = Modifier,
    state: ForecastState,
    onAction: (ForecastIntent) -> Unit,
){
    val vm: ForecastViewModel = viewModel()
    LifecycleEventEffect(androidx.lifecycle.Lifecycle.Event.ON_CREATE) {
        onAction(ForecastIntent.GetForecast(Coord(vm.lat, vm.lon)))
    }
    val df = DecimalFormat("#.#")
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    Row{
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)

        ){
            when(state){
                ForecastState.Loading -> Text(text = "Cargando")
                is ForecastState.Error -> Text(text = "No se pudo recuperar el pronóstico")
                is ForecastState.Success -> {
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Column(modifier = Modifier.padding(16.dp)){
                            Text(text = "Pronóstico extendido", fontSize = 18.sp)
                            for (dayweather in state.forecast.list){
                                val dateTime = LocalDateTime.parse(dayweather.dtTxt, formatter)
                                Row{
                                    Text(
                                        text =
                                        dateTime.dayOfWeek.getDisplayName(java.time.format.TextStyle.FULL, Locale("es")) +
                                                " " + dateTime.format(DateTimeFormatter.ofPattern("HH'hs'")),
                                        textAlign = TextAlign.Center,
                                        fontSize = 16.sp
                                    )
                                    Text(
                                        text = "${df.format(dayweather.main.temp)}º",
                                        textAlign = TextAlign.Right,
                                        fontWeight = FontWeight.Light,
                                        fontSize = 16.sp,
                                    )
                                }
                                Text(
                                    text = "Max. ${df.format(dayweather.main.tempMax)}º | Min. ${df.format(dayweather.main.tempMin)}º",
                                    textAlign = TextAlign.Center,
                                    fontSize = 12.sp
                                )
                                Divider()
                            }
                        }
                    }

                }
            }
        }
    }
}