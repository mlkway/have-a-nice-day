package com.raywenderlich.home_challenge.ui

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.raywenderlich.home_challenge.databinding.DomusFragmentBinding
import kotlinx.coroutines.launch

class DomusFragment : Fragment() {




    private var binding: DomusFragmentBinding? = null

    private val viewModel by viewModels<DomusViewModel>()

    private lateinit var adapter: DomusAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DomusFragmentBinding.inflate(inflater,container,false)
        initRec()
        fetch()
        return binding?.root
    }


    private fun fetch(){
        viewModel.fetchNews().observe(viewLifecycleOwner,{
            lifecycleScope.launch {
                adapter.submitData(it)

            }
        })
    }

    private fun initRec(){
        binding?.recyclerview?.layoutManager = GridLayoutManager(context,1)
        adapter = DomusAdapter(requireContext())
        binding?.recyclerview?.adapter = adapter
    }








}