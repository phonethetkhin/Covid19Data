package com.example.covid19data.vModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covid19data.repo.SummaryRepo
import kotlinx.coroutines.launch

class SummaryViewModel : ViewModel() {
    val summaryRepo = SummaryRepo()
    val summaryLiveData = summaryRepo.summaryLiveData

    fun getSummaryViewModel() = viewModelScope.launch {
        summaryRepo.getSummaryFromAPI()
    }
}