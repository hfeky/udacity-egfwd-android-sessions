package com.husseinelfeky.session2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.husseinelfeky.session2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        initClickListeners()

        return binding.root
    }

    private fun initClickListeners() {
        binding.btnStart.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionFragmentHomeToFragmentMaster())
        }
    }
}
