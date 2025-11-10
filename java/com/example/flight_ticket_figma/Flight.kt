package com.example.flight_ticket_figma

data class Flight(
    val airlineName: String,
    val departureCode: String,
    val departureTime: String,
    val arrivalCode: String,
    val arrivalTime: String,
    val duration: String,
    val price: String,
    val promoCode: String,
    val extraInfo: String? = null
)
