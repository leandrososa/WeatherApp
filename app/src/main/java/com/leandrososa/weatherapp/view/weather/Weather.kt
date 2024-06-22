package com.leandrososa.weatherapp.view.weather

import android.icu.text.DecimalFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leandrososa.weatherapp.model.Coord

@Composable
fun Weather(
    modifier: Modifier = Modifier,
    state : WeatherState,
    onAction: (WeatherIntent)->Unit
    ) {
    // todo: split into components
    val vm: WeatherViewModel = viewModel()
    val df = DecimalFormat("#.#")
    val context = LocalContext.current


    LifecycleEventEffect(androidx.lifecycle.Lifecycle.Event.ON_CREATE) {
        onAction(WeatherIntent.GetWeather(Coord(vm.lat, vm.lon)))
    }
    Row {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            when(state){
                WeatherState.Loading -> Text(text = "Cargando")
                is WeatherState.Error -> Text(text = "No se pudo recuperar el clima")
                is WeatherState.Success -> {
                    Text(
                        text = state.weather.name,
                        textAlign = TextAlign.Center,
                        fontSize = 26.sp
                    )
                    Image(
                        painter =
                            painterResource(id = context.resources.getIdentifier("i${state.weather.weather[0].icon}", "drawable", context.packageName)),
                        contentDescription = "Weather icon",
                    )
                    Text(
                        text = "${df.format(state.weather.main.temp)}º",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Light,
                        fontSize = 84.sp,
                        lineHeight = 30.sp
                    )
                    Text(
                        text = "Max. ${df.format(state.weather.main.tempMax)}º | Min. ${df.format(state.weather.main.tempMin)}º",
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Column(modifier = Modifier.padding(16.dp)){
                            Text(text = "Pronóstico extendido", fontSize = 18.sp)

                        }
                    }
                    Column(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick={onAction(WeatherIntent.ShareWeather)}
                        ){
                            Text("Compartir")
                        }
                    }
                }
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick={onAction(WeatherIntent.ReturnToCities)}
            ){
                Text("Volver")
            }
        }
    }

}



/* @Preview(showBackground = true)
@Composable
fun WeatherPreview() {
    WeatherAppTheme {
        Weather()
    }
} */
