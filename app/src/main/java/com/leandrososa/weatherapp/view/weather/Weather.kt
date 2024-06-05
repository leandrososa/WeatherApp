package com.leandrososa.weatherapp.view.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leandrososa.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun Weather(
    //navController: NavHostController,
    modifier: Modifier = Modifier
    ) {
    // todo: split into components
    val vm: WeatherViewModel = viewModel()
    Row{
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Bariloche",
                textAlign = TextAlign.Center,
                fontSize = 26.sp
            )
            Text(
                text = "22º",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Light,
                fontSize = 84.sp,
                lineHeight = 30.sp
            )
            Text(
                text = "Max. 24º | Min. 17º",
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
        }
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

        }
    }

}



@Preview(showBackground = true)
@Composable
fun WeatherPreview() {
    WeatherAppTheme {
        Weather()
    }
}
