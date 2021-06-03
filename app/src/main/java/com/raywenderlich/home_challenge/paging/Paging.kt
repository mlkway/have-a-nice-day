package com.raywenderlich.home_challenge.paging

import android.widget.Toast
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.raywenderlich.home_challenge.MainActivity
import com.raywenderlich.home_challenge.app.DomusApplication
import com.raywenderlich.home_challenge.data.DomusItem
import com.raywenderlich.home_challenge.erorrhandler.UiErrorInterFace
import com.raywenderlich.home_challenge.erorrhandler.handleNetworkError
import com.raywenderlich.home_challenge.network.NetworkClient
import com.raywenderlich.home_challenge.network.NetworkClient.ApiService
import retrofit2.Retrofit
import java.lang.Exception

class Paging: PagingSource<Int, DomusItem>(),UiErrorInterFace {



    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DomusItem> {
        val position = params.key ?: 1
        return try {
            val response = ApiService.getPagingRequest("news", position)
            val newData = response
            LoadResult.Page(
                data = newData,
                prevKey = if (position == 1) null else position,
                nextKey = if (newData.isEmpty()) null else position + 1
            )

        }catch (e: Exception){
            handleNetworkError(e)
            return LoadResult.Error(e)
        }

    }

    override fun onNoInternet() {
        Toast.makeText(DomusApplication.context,"Internet Error", Toast.LENGTH_SHORT).show()
    }

    override fun onServerError(message: String) {
        Toast.makeText(DomusApplication.context,"Error $message", Toast.LENGTH_SHORT).show()
    }

    override fun getRefreshKey(state: PagingState<Int, DomusItem>): Int? {
        return state.anchorPosition
    }


}