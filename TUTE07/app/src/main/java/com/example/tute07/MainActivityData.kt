package com.example.tute07

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityData:ViewModel() {

    //we can update it not available for out side
    private val _count = MutableLiveData<Int>().apply { value = 0 }

    //can not change out side
    val count:LiveData<Int> = _count

    fun increment(){
        _count.value = _count.value!! + 1
    }




}