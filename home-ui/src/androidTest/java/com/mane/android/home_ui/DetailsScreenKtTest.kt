package com.mane.android.home_ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.runner.AndroidJUnitRunner
import com.mane.android.home_domain.HomeRepository
import com.mane.android.home_domain.domain_data.BreedData
import com.mane.android.home_ui.compose.DetailsScreen
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailsScreenKtTest {

    lateinit var repository: HomeRepository

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        repository = mockk()
    }

    @Test
    fun testEmptyOrNullResponse() {

        composeTestRule.setContent {
            DetailsScreen(DetailsViewModel(repository)) { true }
        }

        composeTestRule.onNodeWithContentDescription("Progress Bar").assertIsDisplayed()
    }
}
