package com.yourappsgeek.adventcalender.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yourappsgeek.adventcalender.R
import com.yourappsgeek.adventcalender.databinding.ItemDaysBinding
import com.yourappsgeek.adventcalender.model.CalenderDay

/**
 * @CreatedBy Ali Ahsan
 *         Author Email: info.aliuetian@gmail.com
 *         Created on: 2020-01-22
 *
 * Custom Adapter to provide a binding, from my custom created data set ,to views that are displayed
 * within a RecyclerView.
 *
 * @param list A mutable list to hold the data set containing calender days.
 * @param helper A helper to hold the reference with linked ui.
 *
 */
class CalenderAdapter(private val list: MutableList<CalenderDay>, private val helper: MainHelper) :
    RecyclerView.Adapter<CalenderViewHolder>() {


    /**
     *
     * One of the methods which needs overriding provided by Base recycleView's adapter.
     * onCreateViewHolder to inflate & assign the custom view/views to corresponding viewHolder.
     *
     * In this case we only have one type view , So we can directly create our custom View
     * holder i.e. CalenderViewHolder
     *
     * @param parent A reference to calling UI viewGroup.
     * @param viewType A reference to hold the viewType.
     * @return ViewHolder depending upon the viewType
     * In our case, it will return CalenderViewHolder
     *
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalenderViewHolder {

        val binding = ItemDaysBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return CalenderViewHolder(binding)
    }

    /**
     *
     * Callback method from UI component to update corresponding data set
     * & notify the adapter.
     *
     * In this case we only have one type view , So we can directly create our custom View
     * holder i.e. CalenderViewHolder
     *
     * @param position tapped item position.
     * @param currentDay True if tapped item is current day .
     *
     */
    fun onClick(position: Int, currentDay: Boolean = false) {
        list[position].backgroundColor = R.color.colorAccent
        if (currentDay) {
            list.forEach { it.isOpenable = false }
        }
        notifyDataSetChanged()
    }

    /**
     *
     * One of the methods which needs overriding provided by Base recycleView's adapter.
     * getItemCount to return adapter size.
     *
     *
     * @return size of loading data set
     *
     */
    override fun getItemCount(): Int = list.size

    /**
     *
     * One of the methods which needs overriding provided by Base recycleView's adapter.
     * onBindViewHolder to bind corresponding data set with viewHolder.
     *
     * @param holder A reference to viewHolder.
     * @param position current item position
     *
     */
    override fun onBindViewHolder(holder: CalenderViewHolder, position: Int) =
        holder.bind(list[position], position, helper)

}