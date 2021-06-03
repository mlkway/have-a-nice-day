package com.raywenderlich.home_challenge.paging

import androidx.lifecycle.LiveData
import androidx.paging.*
import com.raywenderlich.home_challenge.data.DomusItem

object Repo {


    fun getNews(): LiveData<PagingData<DomusItem>>{
        return Pager(
            config = PagingConfig(
                pageSize = 100,
                enablePlaceholders = true
            ),
            pagingSourceFactory = {Paging()}
        ).liveData
    }

}