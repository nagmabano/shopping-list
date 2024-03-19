package com.learning.myshoppinglistapp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class LocationViewModel: ViewModel() {
    private val _location = mutableStateOf<LocationData?>(null)
    val location: State<LocationData?> = _location

    private val _address = mutableStateOf(listOf<GeocodingResults>())
    val address: State<List<GeocodingResults>> = _address

    fun updateLocation(newLocation: LocationData) {
        _location.value = newLocation
    }

    fun fetchAddress(latlng: String) {
        try {
            viewModelScope.launch{
                val result = RetrofitClient.create().getAddressFromCoordinates(
                    latlng,
                    "AIzaSyC7mCVgYLUrfTjvyO21SJVKyTTLuh2ve8M"
                )
                _address.value = result.results
            }
        } catch (e: Exception) {
            Log.d("res1", "${e.cause} - ${e.message}")
        }
    }
}