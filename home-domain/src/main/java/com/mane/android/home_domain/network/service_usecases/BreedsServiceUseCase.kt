package com.mane.android.home_domain.network.service_usecases

import android.util.Log
import com.mane.android.common_libs.data.ApiCallResult
import com.mane.android.home_domain.domain_data.BreedData
import com.mane.android.home_domain.network.response_data.DogBreed
import com.mane.android.home_domain.network.services.BreedsService
import com.mane.android.networking.retrofit.RetrofitBuilder
import com.mane.android.networking.utility.ApiCaller

class BreedsServiceUseCase {

    private val breedsService : BreedsService = RetrofitBuilder.getInstance()
        .baseUrl("https://api.thedogapi.com/v1/")
        .build()
        .create(BreedsService::class.java)

    private suspend fun getBreedsResponse(page: Int? = null, limit: Int? = null): List<DogBreed> {
        return breedsService.getBreeds(page = page, limit = limit)
    }

    private fun mapBreedsResponseToDomainData(response: List<DogBreed>): List<BreedData> {
        Log.d("networkDebug", response.toString())
        return response.map {
            BreedData(
                name = it.name,
                id = it.id,
                temperament = it.temperament,
                weight = it.weight?.metric,
                height = it.height?.metric,
                lifeSpan = it.lifeSpan,
                imageUrl = it.image?.url
            )
        }
    }

    suspend fun getBreeds(page: Int? = null, limit: Int? = null): List<BreedData> {
        return when(val response = ApiCaller.callSafely {
            getBreedsResponse(page, limit)
        }) {
            is ApiCallResult.Success -> mapBreedsResponseToDomainData(response.value)
            else -> emptyList()
        }
    }
}