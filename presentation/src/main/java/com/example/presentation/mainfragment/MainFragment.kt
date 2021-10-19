package com.example.presentation.mainfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.presentation.R
import com.example.presentation.databinding.FragmentMainBinding
import timber.log.Timber

class MainFragment : Fragment(R.layout.fragment_main) {


    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding.goToDescription.setOnClickListener {
//            findNavController().navigate(R.id.action_mainFragment_to_descriptionsAction)
        }

        binding.button.setOnClickListener {
            viewModel.getActions()
        }

        viewModel.actionsDomainModel.observe(viewLifecycleOwner, {
            Timber.d("scope ${it}")
        })
    }
}