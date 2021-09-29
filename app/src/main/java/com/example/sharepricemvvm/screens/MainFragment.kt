package com.example.sharepricemvvm.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sharepricemvvm.R
import com.example.sharepricemvvm.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {


    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding.goToDescription.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_descriptionsAction)
        }
    }
}