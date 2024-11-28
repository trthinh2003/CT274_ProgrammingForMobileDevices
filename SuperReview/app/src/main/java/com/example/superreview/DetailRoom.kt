package com.example.superreview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.superreview.ui.theme.BookingViewModel

@Composable
fun DetailRoom(navController: NavController, dsPhong: BookingViewModel, idPhong: Int) {
    val mo = remember { mutableStateOf(false) }
    val thongtin = remember { mutableStateOf("Thông tin ban đầu") }
    var soLuongNhap by remember { mutableStateOf("1") }
    if (mo.value) {
        AlertDialog(
            onDismissRequest = { mo.value = false },
            title = { Text(text = "Thông báo") },
            text = { Text(text = thongtin.value) },
            confirmButton = {
                Button(
                    onClick = { mo.value = false },
                ) {
                    Text("OK")
                }
            }

        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Chi tiết phòng",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        }
        Column(
            modifier = Modifier.padding(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = dsPhong.listRooms[idPhong - 1].type,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = dsPhong.listRooms[idPhong - 1].image),
                    contentDescription = "Ảnh phòng",
                    contentScale = ContentScale.Inside
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "- Số lượng phòng trống: " + dsPhong.listRooms[idPhong - 1].availableRooms,
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.bodyLarge,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "- Giá mỗi đêm: " + dsPhong.listRooms[idPhong - 1].pricePerNight + "00đ",
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.bodyLarge,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "- Danh sách các tiện nghi:",
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.bodyLarge,
                )
                for (tn in dsPhong.listRooms[idPhong - 1].amenities) {
                    Column(
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Row(modifier = Modifier.padding(start = 10.dp)) {
                            Icon(
                                imageVector = Icons.Filled.ArrowForward,
                                contentDescription = "Icon mũi tên"
                            )
                            Text(
                                text = tn,
                                style = MaterialTheme.typography.bodyLarge,
                            )
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Thông tin đặt phòng:",
                fontSize = 18.sp,
                style = MaterialTheme.typography.bodyLarge,
            )
            Spacer(modifier = Modifier.height(4.dp))
            TextField(
                value = soLuongNhap,
                onValueChange = {soLuongNhap = it},
                label = {Text(text = "Số lượng phòng bạn muốn đặt")},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text(text = "Hủy")
            }
            Button(
                onClick = {
                    val ktraSoLuongNhap: Int = soLuongNhap.toIntOrNull()?:0
                    if (ktraSoLuongNhap < 1) {
                        if (ktraSoLuongNhap == 0) {
                            mo.value = true
                            thongtin.value = "Số lượng nhập không được trống!"
                        }
                        else {
                            mo.value = true
                            thongtin.value = "Số lượng đặt phải lớn hơn 0"
                        }
                    }
                    else if (ktraSoLuongNhap > dsPhong.listRooms[idPhong - 1].availableRooms) {
                        mo.value = true
                        thongtin.value = "Vượt quá số lượng phòng trống có thể đặt!"
                    }
                    else {
                        val soLuongPhongDat: Int = soLuongNhap.toIntOrNull()?:0
                        val soLuongPhongBD = dsPhong.listRooms[idPhong - 1].availableRooms
                        val soLuongPhongConLai: Int = soLuongPhongBD - soLuongPhongDat
                        dsPhong.updateSoLuongPhong(idPhong, soLuongPhongConLai)
                        navController.navigate("PAYMENT/${idPhong}/${soLuongNhap}")
                    }
                }
            ) {
                Text(text = "Đặt phòng")
            }
        }
    }
}