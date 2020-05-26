package com.example.marketpulseevaluation.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marketpulseevaluation.model.Stock
import com.example.marketpulseevaluation.network.StockApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {

    private val _stockApiStatus = MutableLiveData<String>()
    val stockApiStatus: LiveData<String>
        get() = _stockApiStatus

    private val _stockApiResponse = MutableLiveData<List<Stock>>()
    val stockApiResponse: LiveData<List<Stock>>
        get() = _stockApiResponse

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getAllStockList()
    }

    private fun getAllStockList() {

        coroutineScope.launch {
            val getStockResponseDeferred = StockApi.retrofitService.getStocks()
            try {
                val stockResponse = getStockResponseDeferred.await()
                Log.i("MainViewModel", stockResponse.get(0).name)

                _stockApiStatus.value = "Success"
                _stockApiResponse.value = stockResponse
            } catch (exception: Exception) {
                _stockApiStatus.value = "Failure"
                _stockApiResponse.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
