package com.matthew.pettogether.data.Interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class LoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        
        Log.d("API_RESPONSE", "URL: ${request.url()}")
        Log.d("API_RESPONSE", "Response: ${response.peekBody(Long.MAX_VALUE).string()}")
        
        return response
    }
} 