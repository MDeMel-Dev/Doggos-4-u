package com.mane.android.home_ui

import com.mane.android.home_domain.HomeRepository
import com.mane.android.home_domain.domain_data.BreedData
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class DetailsViewModelTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    val dispatcher = StandardTestDispatcher()
    private lateinit var repository: HomeRepository

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        repository = mockk()
    }

    val mockBreedDataList: List<BreedData> = listOf<BreedData>(
        BreedData(
            name = "Hollie", id = 50,
            temperament = "swkcdhw",
            weight = "12Kg",
            height = "56cm",
            lifeSpan = "12 yrs",
            imageUrl = "url"
        ),
        BreedData(
            name = "GGeroia", id = 3,
            temperament = "swkcdhw",
            weight = "10Kg",
            height = "45cm",
            lifeSpan = "9 yrs",
            imageUrl = "url"
        ),
        BreedData(
            name = "Shelly", id = 34,
            temperament = "swkcdhw",
            weight = "10Kg",
            height = "25cm",
            lifeSpan = "10 yrs",
            imageUrl = "url"
        )
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testFindBreedDataFunction() {
        val viewModel = DetailsViewModel(repository)
        coEvery { repository.getBreedDataList() } returns flowOf(mockBreedDataList)

        runTest {
            viewModel.findBreedData(3)
            advanceUntilIdle()
            assertEquals(mockBreedDataList[1], viewModel.breedData.value)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}