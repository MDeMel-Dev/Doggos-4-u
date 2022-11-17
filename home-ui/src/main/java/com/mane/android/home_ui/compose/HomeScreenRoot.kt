package com.mane.android.home_ui.compose

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.mane.android.home_domain.domain_data.BreedData
import com.mane.android.home_ui.HomeViewModel
import com.mxalbert.sharedelements.DelayExit
import com.mxalbert.sharedelements.SharedElementsRoot
import com.mxalbert.sharedelements.SharedElementsRootScope

private var selectedDog: Int by mutableStateOf(-1)
var previousSelectedDog: Int = -1

@Composable
fun HomeScreenRoot(viewModel: HomeViewModel) {

    val breedsDataListState: List<BreedData> by viewModel.breedDataList.collectAsState()

    SharedElementsRoot {
        val dog = selectedDog
        val listState = rememberLazyListState()

        BackHandler(enabled = dog >= 0) {
            changeSelectedDog(-1, breedsDataListState)
        }

        DelayExit(visible = dog < 0) {
            DogsScreen(listState, breedsDataListState)
        }

        DelayExit(visible = dog >= 0) {
            val currentDog = remember { breedsDataListState[dog] }
            DetailScreen(currentDog, breedsDataListState)
        }
    }
}

fun SharedElementsRootScope.changeSelectedDog(dogID: Int, dogs: List<BreedData>) {
    val currentDog = selectedDog
    if (currentDog != dogID) {
        val targetUser = if (dogID >= 0) dogID else currentDog
        if (targetUser >= 0) {
            dogs[targetUser].let {
                it.id?.let { it1 -> it.name?.let { it2 -> prepareTransition(it1, it2) } }
            }
        }
        previousSelectedDog = selectedDog
        selectedDog = dogID
    }
}

