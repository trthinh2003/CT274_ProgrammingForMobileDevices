package com.example.a30daysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val listImg = listOf(
            R.drawable.day_1_plank,
            R.drawable.day_2_cardio,
            R.drawable.day_3_running,
            R.drawable.day_4_aerobic,
            R.drawable.day_5_ropeskipping,
            R.drawable.day_6_walking,
            R.drawable.day_7_basketball,
            R.drawable.day_8_football,
            R.drawable.day_9_volleyball,
            R.drawable.day_10_planche
            )
        val listName = listOf(
            R.string.day_1,
            R.string.day_2,
            R.string.day_3,
            R.string.day_4,
            R.string.day_5,
            R.string.day_6,
            R.string.day_7,
            R.string.day_8,
            R.string.day_9,
            R.string.day_10,
            )
        val listInfo = listOf(
            R.string.day_1_info,
            R.string.day_2_info,
            R.string.day_3_info,
            R.string.day_4_info,
            R.string.day_5_info,
            R.string.day_6_info,
            R.string.day_7_info,
            R.string.day_8_info,
            R.string.day_9_info,
            R.string.day_10_info,
        )
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Gray)
                        .padding(30.dp)
                ) {
                    Text(
                        text = "LỊCH TẬP THỂ DỤC, THỂ THAO",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 21.sp
                    )
                }
                VerticalImageList(listImg, listName, listInfo)
            }
        }

    }
}

//@Preview(showBackground = true)
@Composable
fun VerticalImageList(imageList: List<Int>, nameList: List<Int>, infoList: List<Int>) {
    val scrollState = rememberScrollState()
    var day by remember { mutableStateOf(0) }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .verticalScroll(scrollState)
            .padding(20.dp)
    ) {
        imageList.forEachIndexed {index, image ->
            Box(
                modifier = Modifier
                    .shadow(1.dp, shape = RoundedCornerShape((3.dp)))
                    .border(1.dp, Color.Black)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    day++;
                    Text(
                        text = "Ngày " + day--,
//                        style = MaterialTheme.typography.body,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        stringResource(id = nameList[day]),
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = "Image Description",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .padding(
                                top = if (index == 0) 0.dp else 8.dp,
                                bottom = 8.dp
                            )
                            .fillMaxSize()
                    )
                    Text(
                        stringResource(id = infoList[day]),
                        fontSize = 18.sp
                    )
                    day++
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}



