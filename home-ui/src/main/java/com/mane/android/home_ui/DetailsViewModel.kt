package com.mane.android.home_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mane.android.home_domain.HomeRepository
import com.mane.android.home_domain.domain_data.BreedData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {

    private val repository = HomeRepository()

    private val _breedData = MutableStateFlow<BreedData?>(null)
    val breedData: StateFlow<BreedData?> = _breedData

    fun findBreedData(id: Int) {
        viewModelScope.launch {
            repository.getBreedDataList().collectLatest {
                _breedData.value = it.find { it.id == id }
            }
        }
    }
}