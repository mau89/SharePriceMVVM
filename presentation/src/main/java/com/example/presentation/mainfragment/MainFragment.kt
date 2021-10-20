package com.example.presentation.mainfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.actiondomain.globalDependenciesProvider
import com.example.presentation.R
import com.example.presentation.databinding.FragmentMainBinding
import timber.log.Timber

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

//    private val viewModel: MainViewModel by viewModels(factoryProducer = {
//        object : ViewModelProvider.Factory {
//            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//                return MainViewModel(globalDependenciesProvider.provideActionsInteractor()) as T
//            }
//        }
//    })

    internal lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainFragmentDependencyProvider.inject(this)
    }

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