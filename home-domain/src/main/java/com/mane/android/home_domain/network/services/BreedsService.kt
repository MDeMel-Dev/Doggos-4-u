package com.mane.android.home_domain.network.services

import com.mane.android.home_domain.network.response_data.DogBreed
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface BreedsService {

    @GET("breeds")
    suspend fun getBreeds(
        @Header("x-api-key") qui: String? = null,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null
    ): List<DogBreed>
}

//live_nTrnFv9bjRFToB4CwyO39ylKSH0rcxqDn3kR6xmBKOnOch65JxkVqWe6MmJc3Crc