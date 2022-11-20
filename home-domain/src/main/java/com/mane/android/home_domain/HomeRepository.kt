package com.mane.android.home_domain

import com.mane.android.home_domain.domain_data.BreedData
import com.mane.android.home_domain.network.service_usecases.BreedsServiceUseCase
import com.mane.android.home_domain.network.services.BreedsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val breedsServiceUseCase: BreedsServiceUseCase
) {

    suspend fun getBreedDataList(
        page: Int? = null,
        limit: Int? = null
    ): Flow<List<BreedData>> {
        return flow {
           emit(breedsServiceUseCase.getBreeds(page, limit))
        }.flowOn(Dispatchers.IO)
    }
}