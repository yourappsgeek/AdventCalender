package com.yourappsgeek.adventcalender.presentation

import com.yourappsgeek.adventcalender.model.CalenderDay

/**
 * @CreatedBy Ali Ahsan
 *         Author Email: info.aliuetian@gmail.com
 *         Created on: 2020-01-22
 */

/**
 * Helper interface to communicate between
 * viewModels & activity
 */
interface MainHelper {

    /**
     * helper function to pass data to activity
     */
    fun populateList(daysList: MutableList<CalenderDay>)

    /**
     * helper function to mark tapped day as opened
     */
    fun openCalenderDay(position: Int)

    /**
     * helper function to open current day
     */
    fun openCurrentDay(position: Int)
}