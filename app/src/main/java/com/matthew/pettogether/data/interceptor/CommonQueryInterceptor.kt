package com.matthew.pettogether.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class CommonQueryInterceptor : Interceptor {
    companion object {
        private const val SERVICE_KEY = "ewS5WWLdbJMGS5s/76P6jXu1rqZBO/+IUAGkuVuMc8FVvDevts1hRC26ED0WivHm6jcRLXgIVcJ1WLLyjC2j/w=="
        private const val MOBILE_OS = "AND"
        private const val MOBILE_APP = "PetTogether"
        private const val TYPE = "json"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("serviceKey", SERVICE_KEY)
            .addQueryParameter("MobileOS", MOBILE_OS)
            .addQueryParameter("MobileApp", MOBILE_APP)
            .addQueryParameter("_type", TYPE)
            .build()

        val requestBuilder = original.newBuilder()
            .url(url)

        return chain.proceed(requestBuilder.build())
    }
}