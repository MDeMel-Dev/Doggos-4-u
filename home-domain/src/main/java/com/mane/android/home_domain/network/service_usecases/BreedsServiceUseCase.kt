package com.mane.android.home_domain.network.service_usecases

import android.util.Log
import com.mane.android.common_libs.data.ApiCallResult
import com.mane.android.home_domain.domain_data.BreedData
import com.mane.android.home_domain.network.response_data.DogBreed
import com.mane.android.home_domain.network.response_data.mapToBreedData
import com.mane.android.home_domain.network.services.BreedsService
import com.mane.android.networking.retrofit.RetrofitBuilder
import com.mane.android.networking.utility.ApiCaller
import javax.inject.Inject

class BreedsServiceUseCase @Inject constructor(
    private val breedsService : BreedsService
) {

    private suspend fun getBreedsResponse(page: Int? = null, limit: Int? = null): List<DogBreed> {
        return breedsService.getBreeds(page = page, limit = limit)
    }

    suspend fun getBreeds(page: Int? = null, limit: Int? = null): List<BreedData> {
        return when(val response = ApiCaller.callSafely {
            getBreedsResponse(page, limit)
        }) {
            is ApiCallResult.Success -> {
                response.value.map {
                    it.mapToBreedData()
                }
            }
            else -> emptyList()
        }
    }
}