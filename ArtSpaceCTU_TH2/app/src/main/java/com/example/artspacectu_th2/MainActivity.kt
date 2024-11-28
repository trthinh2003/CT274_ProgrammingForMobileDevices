package com.example.artspacectu_th2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspacectu_th2.ui.theme.ArtSpaceCTU_TH2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceCTU_TH2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GetLayOut(
                        modifier = Modifier.padding(innerPadding)
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GetLayOut(modifier: Modifier = Modifier) {
    var anhHienTai by remember { mutableStateOf(0) }
    val listAnh = listOf(
        Anh(R.drawable.doraemon, "Doraemon", "Fujiko F. Fujio", "1969"),
        Anh(R.drawable.kuroko, "Kuroko no basket", "Tadatoshi Fujimaki", "2008"),
        Anh(R.drawable.luffy, "Luffy", "Oda Eiichiro", "1999"),
        Anh(R.drawable.naruto, "Naruto", "Kishimoto Masashi", "1999")
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = listAnh[anhHienTai].id),
            contentDescription = listAnh[anhHienTai].title,
            modifier = modifier
                .fillMaxSize()
                .weight(1f)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .padding(20.dp)
                .background(Color.LightGray)
        ) {
            Text(
                text = listAnh[anhHienTai].title,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = listAnh[anhHienTai].artist,
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic
            )
            Text(
                text = listAnh[anhHienTai].year,
                fontSize = 20.sp
            )
        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                if (anhHienTai > 0) anhHienTai--
                else anhHienTai = listAnh.size - 1
            }) {
                Text(
                    text = "Previous",
                    fontSize = 18.sp
                )
            }
            Button(onClick = {
                if (anhHienTai < listAnh.size - 1) anhHienTai++
                else anhHienTai = 0

            }) {
                Text(
                    text = "Next",
                    fontSize = 18.sp
                )
            }
        }
    }
}
