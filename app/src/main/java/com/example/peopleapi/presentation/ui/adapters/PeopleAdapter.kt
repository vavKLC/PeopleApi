package com.example.peopleapi.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.peopleapi.presentation.base.BaseDiffUtil
import com.example.peopleapi.databinding.ItemPeopleBinding
import com.example.peopleapi.presentation.models.PeopleModelUI

class PeopleAdapter : ListAdapter<PeopleModelUI, PeopleAdapter.PeopleViewHolder>(BaseDiffUtil()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PeopleViewHolder =
        PeopleViewHolder(
            ItemPeopleBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PeopleAdapter.PeopleViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)        }
    }

    class PeopleViewHolder(private val binding: ItemPeopleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: PeopleModelUI) {
            binding.eyeTv.text = data.name
            binding.genderTv.text = data.name
        }

    }

}
