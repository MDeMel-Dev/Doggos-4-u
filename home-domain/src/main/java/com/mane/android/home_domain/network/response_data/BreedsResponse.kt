package com.mane.android.home_domain.network.response_data

import com.squareup.moshi.Json

data class DogBreed(
    @Json(name = "weight") val weight: Weight? = Weight(),
    @Json(name = "height") val height: Height? = Height(),
    @Json(name = "id") val id: Int? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "bred_for") val bredFor: String? = null,
    @Json(name = "breed_group") val breedGroup: String? = null,
    @Json(name = "life_span") val lifeSpan: String? = null,
    @Json(name = "temperament") val temperament: String? = null,
    @Json(name = "origin") val origin: String? = null,
    @Json(name = "reference_image_id") val referenceImageId: String? = null,
    @Json(name = "image") val image: Image? = Image()
)

data class Weight(
    @Json(name = "imperial") var imperial: String? = null,
    @Json(name = "metric") var metric: String? = null
)

data class Height(
    @Json(name = "imperial") var imperial: String? = null,
    @Json(name = "metric") var metric: String? = null
)

data class Image(
    @Json(name = "id") var id: String? = null,
    @Json(name = "width") var width: Int? = null,
    @Json(name = "height") var height: Int? = null,
    @Json(name = "url") var url: String? = null
)