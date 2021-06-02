package com.raywenderlich.home_challenge.util

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import javax.security.auth.callback.Callback

class LoadMoreListener(val callback: () -> Unit): RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val glayoutManager = (recyclerView.layoutManager as GridLayoutManager)
            if (recyclerView.adapter?.itemCount == glayoutManager.findLastVisibleItemPosition() + 1){
            callback
        }
    }

}