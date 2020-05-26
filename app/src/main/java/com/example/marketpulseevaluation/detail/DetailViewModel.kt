package com.example.marketpulseevaluation.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marketpulseevaluation.model.Criteria
import com.example.marketpulseevaluation.model.Stock

class DetailViewModel(stock: Stock, app: Application) : AndroidViewModel(app) {


    private val _selectedStock = MutableLiveData<Stock>()
    val selectedStock: LiveData<Stock>
        get() = _selectedStock

    private val _criteriaList = MutableLiveData<List<Criteria>>()
    val criteriaList: LiveData<List<Criteria>>
        get() = _criteriaList

    init {
        _selectedStock.value = stock
        _criteriaList.value = stock.criteria
    }
}