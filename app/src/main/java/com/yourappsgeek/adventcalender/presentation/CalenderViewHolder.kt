package com.yourappsgeek.adventcalender.presentation

import androidx.recyclerview.widget.RecyclerView
import com.yourappsgeek.adventcalender.databinding.ItemDaysBinding
import com.yourappsgeek.adventcalender.model.CalenderDay

/**
 * @CreatedBy Ali Ahsan
 *         Author Email: info.aliuetian@gmail.com
 *         Created on: 2020-01-22
 *
 * Custom viewHolder to hold day's dataSet
 *
 * @param binding A reference to item's xml view
 *
 */
class CalenderViewHolder(private val binding: ItemDaysBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(day: CalenderDay, position: Int, helper: MainHelper) {
        binding.model = day
        val viewModel = CalenderViewModel(position, helper)
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }
}