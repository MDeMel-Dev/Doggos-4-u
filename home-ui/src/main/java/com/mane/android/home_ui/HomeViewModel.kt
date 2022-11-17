package com.mane.android.home_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mane.android.home_domain.HomeRepository
import com.mane.android.home_domain.domain_data.BreedData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = HomeRepository()

    private val _breedDataList = MutableStateFlow(emptyList<BreedData>())
    val breedDataList: StateFlow<List<BreedData>> = _breedDataList

    init {
        viewModelScope.launch {
            repository.getBreedDataList().collectLatest {
                _breedDataList.value = it
            }
        }
    }
}