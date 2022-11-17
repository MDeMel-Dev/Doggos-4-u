package com.mane.android.home_domain

import com.mane.android.home_domain.domain_data.BreedData
import com.mane.android.home_domain.network.service_usecases.BreedsServiceUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class HomeRepository {

    private val breedsServiceUseCase = BreedsServiceUseCase()

    suspend fun getBreedDataList(
        page: Int? = null,
        limit: Int? = null
    ): Flow<List<BreedData>> {
        return flow<List<BreedData>> {
           emit(breedsServiceUseCase.getBreeds(page, limit))
        }.flowOn(Dispatchers.IO)
    }
}