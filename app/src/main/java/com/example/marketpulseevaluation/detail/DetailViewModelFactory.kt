package com.example.marketpulseevaluation.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.marketpulseevaluation.model.Stock

class DetailViewModelFactory(
    private val stock: Stock,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(stock, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
