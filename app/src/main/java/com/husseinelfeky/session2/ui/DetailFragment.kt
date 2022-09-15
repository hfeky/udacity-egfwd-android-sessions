package com.husseinelfeky.session2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.husseinelfeky.session2.databinding.FragmentDetailBinding
import com.husseinelfeky.session2.viewmodels.SharedViewModel


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        binding.user = viewModel.user

        initClickListeners()

        return binding.root
    }

    private fun initClickListeners() {
        binding.btnSave.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
