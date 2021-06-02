package com.raywenderlich.home_challenge.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.raywenderlich.home_challenge.databinding.DomusFragmentBinding
import com.raywenderlich.home_challenge.util.LoadMoreListener

class DomusFragment : Fragment() {




    private var binding: DomusFragmentBinding? = null

    private val viewModel by viewModels<DomusViewModel>()

    private val adapter = DomusAdapter()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DomusFragmentBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = GridLayoutManager(context,1)
        binding?.apply {
            recyclerview.layoutManager = layoutManager
            recyclerview.adapter = adapter
            recyclerview.addOnScrollListener(LoadMoreListener() {
                viewModel.onScrollEndReached()
            })
            viewModel.items.observe(viewLifecycleOwner){
                adapter.homeList = it
                adapter.notifyDataSetChanged()
            }



        }

    }



}