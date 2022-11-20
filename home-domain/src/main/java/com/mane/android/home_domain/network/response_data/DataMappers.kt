package com.mane.android.home_domain.network.response_data

import android.util.Log
import com.mane.android.home_domain.domain_data.BreedData

fun DogBreed.mapToBreedData(): BreedData {
    return BreedData(
            name = this.name,
            id = this.id,
            temperament = this.temperament,
            weight = this.weight?.metric,
            height = this.height?.metric,
            lifeSpan = this.lifeSpan,
            imageUrl = this.image?.url
        )
}