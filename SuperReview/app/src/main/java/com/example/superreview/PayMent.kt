package com.example.superreview

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.superreview.ui.theme.BookingViewModel

@Composable
fun PayMent(navController: NavController, dsPhong: BookingViewModel, idPhong: Int, soLuongDat: String) {
    val soLuongPhongDat: Int = soLuongDat.toIntOrNull()?:0
    val tongTienDat: Double = dsPhong.listRooms[idPhong - 1].pricePerNight * soLuongPhongDat
//    val soLuongPhongBD = dsPhong.listRooms[idPhong - 1].availableRooms*1
//    val soLuongPhongConLai: Int = (soLuongPhongBD - soLuongPhongDat+1-1)*1
//    dsPhong.updateSoLuongPhong(idPhong, soLuongPhongConLai)
    val mo = remember { mutableStateOf(true) }
    if (mo.value) {
        AlertDialog(
            onDismissRequest = { mo.value = false },
            title = { Text(text = "Thông báo") },
            text = { Text(text = "Đặt phòng thành công, vui lòng thực hiện thanh toán trong 3 giờ.") },
            confirmButton = {
                Button(
                    onClick = { mo.value = false },
                ) {
                    Text("OK")
                }
            }

        )
    }
    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 25.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Thông tin thanh toán",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge,
                )
            }
        }
        Column(
            Modifier.verticalScroll(rememberScrollState()).padding(bottom = 35.dp)
        ) {
            Row(
                modifier = Modifier
                    .clickable(
                        indication = rememberRipple(bounded = true),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {}
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp, end = 15.dp)
                ) {
                    Row(Modifier.padding(start = 10.dp)) {
                        Text(
                            text = "Loại phòng: " + dsPhong.listRooms[idPhong - 1].type,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                    }
                    Divider(
                        color = Color.LightGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 10.dp)
                    )
                    Row(Modifier.padding(start = 10.dp)) {
                        Text(
                            text = "Giá phòng: " + dsPhong.listRooms[idPhong - 1].pricePerNight + "00đ",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                    }
                    Divider(
                        color = Color.LightGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 10.dp)
                    )
                    Row(Modifier.padding(start = 10.dp)) {
                        Text(
                            text = "Danh sách tiện nghi:",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                        Column(
                            modifier = Modifier.padding(start = 20.dp)
                        ) {
                            for (tn in dsPhong.listRooms[idPhong - 1].amenities) {
                                Row() {
                                    Icon(
                                        imageVector = Icons.Filled.ArrowForward,
                                        contentDescription = "Icon mũi tên"
                                    )
                                    Text(
                                        text = tn,
                                        style = MaterialTheme.typography.bodyLarge,
                                        modifier = Modifier.padding(bottom = 10.dp)
                                    )
                                }
                            }
                        }
                    }
                    Divider(
                        color = Color.LightGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 10.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.padding(start = 20.dp)
            ) {
                Text(
                    text = "Số lượng phòng đã đặt: " + soLuongDat,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.padding(start = 5.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Icon mũi tên"
                )
                Text(
                    text = "Tổng tiền: " + tongTienDat+ "00đ",
                    fontSize = 25.sp,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        navController.navigate("HOME_SCREEN") {
                            popUpTo(navController.graph.startDestinationId)
                            {
                                inclusive = true
                            }
                        }
                    }
                ) {
                    Text(text = "Về trang chủ")
                }
            }

        }
    }
}