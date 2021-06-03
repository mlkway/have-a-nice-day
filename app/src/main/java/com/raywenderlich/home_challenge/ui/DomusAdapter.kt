package com.raywenderlich.home_challenge.ui

import android.content.Context
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raywenderlich.home_challenge.data.DomusItem
import com.raywenderlich.home_challenge.databinding.ItemViewBinding
import com.raywenderlich.home_challenge.databinding.ProgressBarBinding
import java.lang.RuntimeException
import kotlin.coroutines.coroutineContext
import kotlin.math.abs

class DomusAdapter(private val context: Context):PagingDataAdapter<DomusItem,RecyclerView.ViewHolder>(Diff) {


    companion object {
        const val VIEW_TYPE_DOMUS = 1
        const val VIEW_TYPE_LOADER = 2

        private val Diff = object: DiffUtil.ItemCallback<DomusItem>(){

            override fun areItemsTheSame(oldItem: DomusItem, newItem: DomusItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: DomusItem, newItem: DomusItem): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }

    inner class DomusViewHolder(private val binding: ItemViewBinding):RecyclerView.ViewHolder(binding.root){

        private lateinit var dataItem: DomusItem
        fun onBind(){
            dataItem = getItem(absoluteAdapterPosition)!!
            binding.titleTextView.text = dataItem.titleKA
            Glide.with(context).load(dataItem.cover)
                .into(binding.newsCoverImageView)

        }

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
                holder.onBind()

            }
            is LoadingViewHolder ->{
                holder.binding.progressBar.isVisible
            }
        }
    }





}