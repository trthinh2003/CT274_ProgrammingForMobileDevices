package com.example.superreview.ui.theme

data class Room(
    val id: Int,
    val type: String,
    val image: Int,
    val pricePerNight: Double,
    val amenities: List<String>,
    var availableRooms: Int
)