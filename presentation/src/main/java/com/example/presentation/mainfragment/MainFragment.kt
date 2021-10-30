package com.example.presentation.mainfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.actiondomain.domainDiProvider
import com.example.domain.actiondomain.globalDependenciesProvider
import com.example.presentation.R
import com.example.presentation.databinding.FragmentMainBinding
import com.example.presentation.mainfragment.di.DaggerMainFragmentComponent
import com.example.presentation.mainfragment.di.MainFragmentModule
import timber.log.Timber
import javax.inject.Inject

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    @Inject
    internal lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMainFragmentComponent
            .factory()
            .create(
                this,
                domainDiProvider = domainDiProvider,
                MainFragmentModule()
            )
            .inject(this)
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
            Timber.d(it.name)
            Toast.makeText(requireContext(), "asdada", Toast.LENGTH_SHORT).show()
        })
    }
}