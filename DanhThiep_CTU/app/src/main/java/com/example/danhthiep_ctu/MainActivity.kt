package com.example.danhthiep_ctu

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.danhthiep_ctu.ui.theme.DanhThiep_CTUTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DanhThiep_CTUTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    GetLayOut()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GetLayOut() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.pumpkin_logo),
            contentDescription = "Logo",
            contentScale = ContentScale.FillHeight
        )
        Text(
            text = "Thinh Huynh",
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Halloween Card"
        )
        Spacer(modifier = Modifier.height(120.dp))
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            GetInfo(R.drawable.phone_icon,"0886 362 233")
            GetInfo(R.drawable.branch_icon,"@halloweencard")
            GetInfo(R.drawable.email_icon, "thinhb2110029@student.ctu.edu.vn")
        }
    }
}

@Composable
fun GetInfo(icon: Int, info: String) {
    Row {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "Icon",
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = info
        )
    }
    Spacer(modifier = Modifier.height(5.dp))
}