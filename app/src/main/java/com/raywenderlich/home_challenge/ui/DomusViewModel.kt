package com.raywenderlich.home_challenge.ui

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raywenderlich.home_challenge.data.Domus
import com.raywenderlich.home_challenge.data.DomusItem
import com.raywenderlich.home_challenge.network.NetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class DomusViewModel : ViewModel() {

    private val _items = MutableLiveData<List<DomusItem>>()

    val items: LiveData<List<DomusItem>> get() = _items


    fun onScrollEndReached(){
        loadMore()
    }


    init {
        loadMore()
    }



    private fun loadMore(){
        viewModelScope.launch {
            try {
                val data = withContext(Dispatchers.IO){
                    NetworkClient.ApiService.getRequest()
                }
                _items.postValue((_items.value ?: emptyList()) + data)
            }catch (e: Exception){

            }
        }
    }

}