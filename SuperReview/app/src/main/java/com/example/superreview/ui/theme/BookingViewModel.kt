package com.example.superreview.ui.theme

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.superreview.R

class BookingViewModel : ViewModel() {
    var listRooms = mutableStateListOf(
        Room(
            id = 1,
            type = "Standard Room",
            image = R.drawable.standard_room,
            pricePerNight = 100.000,
            amenities = listOf("Wi-Fi", "Bồn tắm", "TV"),
            availableRooms = 5
        ),
        Room(
            id = 2,
            type = "Deluxe Room",
            image = R.drawable.deluxe_room,
            pricePerNight = 80.000,
            amenities = listOf("Wi-Fi", "Điều hòa"),
            availableRooms = 5
        ),
        Room(
            id = 3,
            type = "Suite",
            image = R.drawable.suite,
            pricePerNight = 150.000,
            amenities = listOf("Wi-Fi", "Bồn tắm", "Minibar", "TV"),
            availableRooms = 5
        ),
        Room(
            id = 4,
            type = "Executive Room",
            image = R.drawable.execute_room,
            pricePerNight = 120.000,
            amenities = listOf("Wi-Fi", "Điều hòa", "TV"),
            availableRooms = 5),
        Room(
            id = 5,
            type = "Family Room",
            image = R.drawable.family_room,
            pricePerNight = 400.000,
            amenities = listOf("Wi-Fi", "Điều hòa"),
            availableRooms = 5
        ),
        Room(
            id = 6,
            type = "Penthouse Suite",
            image = R.drawable.penthouse_suite,
            pricePerNight = 200.000,
            amenities = listOf("Wi-Fi", "Bồn tắm", "Minibar", "TV", "Ban công riêng"),
            availableRooms = 3
        ),
        Room(
            id = 7,
            type = "Single Room",
            image = R.drawable.single_room,
            pricePerNight = 500.000,
            amenities = listOf("Wi-Fi", "TV"),
            availableRooms = 10
        )
    )
    fun updateSoLuongPhong(idPhong: Int, soLuongConLai: Int) {
        listRooms[idPhong - 1].availableRooms = soLuongConLai
    }
}