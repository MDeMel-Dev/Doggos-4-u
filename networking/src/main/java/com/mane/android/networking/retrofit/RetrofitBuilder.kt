package com.mane.android.networking.retrofit

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class RetrofitBuilder @Inject constructor() {

    companion object {
        fun getInstance(): Retrofit.Builder {
            return Retrofit.Builder()
                .client(OkHttpClientBuilder.getOkHttpClient())
                .addConverterFactory(MoshiConverterFactory.create(MoshiBuilder.getMoshiConverter()))
        }
    }
}