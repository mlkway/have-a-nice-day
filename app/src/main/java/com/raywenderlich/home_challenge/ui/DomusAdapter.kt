package com.raywenderlich.home_challenge.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raywenderlich.home_challenge.data.Domus
import com.raywenderlich.home_challenge.data.DomusItem
import com.raywenderlich.home_challenge.databinding.ItemViewBinding
import com.raywenderlich.home_challenge.databinding.ProgressBarBinding
import java.lang.RuntimeException

class DomusAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var homeList: List<DomusItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var moreData = true



    class DomusViewHolder(val binding: ItemViewBinding):RecyclerView.ViewHolder(binding.root){

    }

    class LoadingViewHolder(val binding: ProgressBarBinding):RecyclerView.ViewHolder(binding.root)


    override fun getItemViewType(position: Int): Int {
        return if(itemCount -1 == position) VIEW_TYPE_LOADER else VIEW_TYPE_DOMUS
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder=
        when(viewType){
            VIEW_TYPE_LOADER -> LoadingViewHolder(ProgressBarBinding.inflate(LayoutInflater.from(parent.context)))

            VIEW_TYPE_DOMUS -> DomusViewHolder(ItemViewBinding.inflate(LayoutInflater.from(parent.context)))

            else -> throw RuntimeException("Unknown ViewType")
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is DomusViewHolder ->{
                val item = homeList[position]
                holder.binding.titleTextView.text = item.titleKA
                Glide.with(holder.itemView).load(item.cover)
                    .into(holder.binding.newsCoverImageView)

            }
            is LoadingViewHolder ->{
                holder.binding.progressBar.isVisible
                moreData = true
            }
        }
    }

    override fun getItemCount() = homeList.size + 1


    companion object{
        const val VIEW_TYPE_DOMUS = 1
        const val VIEW_TYPE_LOADER = 2
    }

}