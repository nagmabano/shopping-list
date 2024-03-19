package com.learning.myshoppinglistapp

data class LocationData(
    val latitude: Double,
    val longitude: Double
)

data class GeolocationResponse(
    val results: List<GeocodingResults>,
    val status: String
)

data class GeocodingResults (
    val formatted_address: String
)