package com.example.peopleapi.presentation.ui.fragments

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.peopleapi.R
import com.example.peopleapi.presentation.base.BaseFragment
import com.example.peopleapi.presentation.extensions.submitData
import com.example.peopleapi.databinding.FragmentPeopleBinding
import com.example.peopleapi.presentation.ui.adapters.PeopleAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment : BaseFragment<PeopleViewModel, FragmentPeopleBinding>(
    R.layout.fragment_people
) {
    override val viewModel: PeopleViewModel by viewModels()
    override val binding by viewBinding(FragmentPeopleBinding::bind)
    private val peopleAdapter = PeopleAdapter()

    override fun setupSubscribe() {
        viewModel.peopleState.collectUIState(
            error = {
                Log.e("error", it)
            },
            success = {
                peopleAdapter.submitData(it)
                Log.e("success", it.toString())
            }
        )
    }

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.recyclerView.apply {
            adapter = peopleAdapter
        }
    }


}