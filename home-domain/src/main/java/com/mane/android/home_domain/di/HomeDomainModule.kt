package com.mane.android.home_domain.di

import com.mane.android.home_domain.network.services.BreedsService
import com.mane.android.networking.retrofit.RetrofitBuilder
import dagger.Module
import dagger.Provides

@Module
class HomeDomainModule {

    @Provides
    fun provideBreedsService(): BreedsService {
        return RetrofitBuilder.getInstance()
            .baseUrl("https://api.thedogapi.com/v1/")
            .build()
            .create(BreedsService::class.java)
    }
}