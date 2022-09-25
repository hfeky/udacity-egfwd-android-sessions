package com.husseinelfeky.session2.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.husseinelfeky.session2.databinding.FragmentMasterBinding
import com.husseinelfeky.session2.viewmodels.SharedViewModel

class MasterFragment : Fragment() {

    private lateinit var binding: FragmentMasterBinding

    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMasterBinding.inflate(layoutInflater)
        binding.user = viewModel.user

        initClickListeners()
        Log.i("Lifecycle", "onCreateView")

        return binding.root
    }

    private fun initClickListeners() {
        binding.btnEdit.setOnClickListener {
            findNavController().navigate(MasterFragmentDirections.actionFragmentMasterToFragmentDetail())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("Lifecycle", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Lifecycle", "onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("Lifecycle", "onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("Lifecycle", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Lifecycle", "onDetach")
    }
}
