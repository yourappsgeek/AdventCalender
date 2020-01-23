package com.yourappsgeek.adventcalender.presentation

import androidx.lifecycle.ViewModel

/**
 * @CreatedBy Ali Ahsan
 *         Author Email: info.aliuetian@gmail.com
 *         Created on: 2020-01-22
 *
 * Custom viewModel to de-couple viewHolder's logic from our holder i.e. CalenderViewHolder.
 *
 * @param position current item's position.
 * @param helper A reference to communicate with MainActivity.
 *
 */
class CalenderViewModel(
    private val position: Int,
    private val helper: MainHelper
) : ViewModel() {


    /**
     * A onClicked method which is bind through xml.
     *
     * Called when a day other than current but still openable is clicked, it will
     * then call the corresponding activity's function.
     *
     */
    fun onDayClicked() {
        helper.openCalenderDay(position)
    }

    /**
     *
     * Called when the current day is clicked which will
     * then call the corresponding activity's function.
     *
     */
    fun currentDayClicked() {
        helper.openCurrentDay(position)
    }
}