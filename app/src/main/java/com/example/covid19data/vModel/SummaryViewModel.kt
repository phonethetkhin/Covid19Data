package com.example.covid19data.vModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covid19data.repo.SummaryRepo
import kotlinx.coroutines.launch

class SummaryViewModel : ViewModel() {
    private val summaryRepo = SummaryRepo()
    val summaryLiveData = summaryRepo.summaryLiveData

    fun getSummaryViewModel(context:Context) = viewModelScope.launch {
        summaryRepo.getSummaryFromAPI(context)
    }
}