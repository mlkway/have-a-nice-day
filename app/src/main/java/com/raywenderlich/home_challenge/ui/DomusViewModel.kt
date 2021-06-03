package com.raywenderlich.home_challenge.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.paging.cachedIn
import com.raywenderlich.home_challenge.data.DomusItem
import com.raywenderlich.home_challenge.network.NetworkClient
import com.raywenderlich.home_challenge.paging.Repo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DomusViewModel : ViewModel() {



    private var loadingLiveData = MutableLiveData<Boolean>()

    val _loadingLiveData: MutableLiveData<Boolean> get() = loadingLiveData

    fun fetchNews(): LiveData<PagingData<DomusItem>>{
        _loadingLiveData.postValue(true)
        return Repo.getNews().cachedIn(viewModelScope)
    }








}