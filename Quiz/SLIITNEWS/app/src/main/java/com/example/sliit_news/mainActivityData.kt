package com.example.sliit_news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sliit_news.database.Customer

class mainActivityData:ViewModel() {

    private val _data = MutableLiveData<List<Customer>>()

    val data:LiveData<List<Customer>> = _data

    fun setData(data: List<Customer>){
        _data.value = data
    }
}