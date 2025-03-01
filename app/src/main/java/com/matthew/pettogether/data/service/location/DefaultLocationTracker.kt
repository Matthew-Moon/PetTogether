package com.matthew.pettogether.data.service.location

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.matthew.pettogether.domain.service.LocationTracker
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class DefaultLocationTracker @Inject constructor(
    private val locationClient: FusedLocationProviderClient,
    private val application: Application
) : LocationTracker {
    
    override suspend fun getCurrentLocation(): LocationTracker.Location {
        if (!checkLocationPermissions()) {
            throw LocationException("위치 권한이 없습니다.")
        }
        
        if (!isLocationEnabled()) {
            throw LocationException("위치 서비스가 비활성화되어 있습니다.")
        }

        return suspendCancellableCoroutine { continuation ->
            locationClient.lastLocation.apply {
                if(isComplete) {
                    handleLocationResult(result, continuation)
                    return@suspendCancellableCoroutine
                }
                
                addOnSuccessListener { location ->
                    handleLocationResult(location, continuation)
                }
                
                addOnFailureListener { exception ->
                    continuation.resumeWithException(
                        LocationException("위치 정보를 가져오는데 실패했습니다: ${exception.message}")
                    )
                }
                
                addOnCanceledListener {
                    continuation.cancel()
                }
            }
        }
    }
    
    private fun checkLocationPermissions(): Boolean {
        val hasFineLocationPermission = ContextCompat.checkSelfPermission(
            application,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        
        val hasCoarseLocationPermission = ContextCompat.checkSelfPermission(
            application,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        
        return hasFineLocationPermission && hasCoarseLocationPermission
    }
    
    private fun isLocationEnabled(): Boolean {
        val locationManager = application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }
    
    private fun handleLocationResult(
        location: android.location.Location?,
        continuation: kotlinx.coroutines.CancellableContinuation<LocationTracker.Location>
    ) {
        if (location != null) {
            continuation.resume(
                LocationTracker.Location(
                    latitude = location.latitude,
                    longitude = location.longitude
                )
            )
        } else {
            continuation.resumeWithException(
                LocationException("현재 위치를 찾을 수 없습니다.")
            )
        }
    }
}

class LocationException(message: String) : Exception(message) 