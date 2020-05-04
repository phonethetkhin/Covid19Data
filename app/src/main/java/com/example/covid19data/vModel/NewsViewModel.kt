package com.example.covid19data.vModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covid19data.repo.NewsRepo
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val newsRepo = NewsRepo()
    val newsLiveData = newsRepo.newsLiveData

    fun getNewsLiveDataVM(context: Context) = viewModelScope.launch {
        newsRepo.getApiNewsLiveData(context)
    }
}
