package com.yourappsgeek.adventcalender.presentation

import androidx.lifecycle.ViewModel
import com.yourappsgeek.adventcalender.model.CalenderDay
import java.util.*

/**
 * @CreatedBy Ali Ahsan
 *         Author Email: info.aliuetian@gmail.com
 *         Created on: 2020-01-22
 *
 * View model to hold the main activity logic and communicate back and forth.
 *
 * @param helper A reference to main UI activity
 */
class MainViewModel(private val helper: MainHelper) : ViewModel() {

    // The list of days
    private var daysList: MutableList<CalenderDay> = mutableListOf()

    // Initialize the daysList and populate the list
    init {

        loadList()
    }

    /**
     *
     * Get the current day and add it to the list first
     * and then fill the list with remaining 23 days based on the current day.
     * At the end, its shuffle the list to make it random and pass it to main UI.
     *
     */
    fun loadList() {
        daysList.clear()

        val currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        var count = 1

        var calenderDay = CalenderDay(
            day = currentDay.toString(),
            currentDay = true,
            isOpenable = true
        )

        daysList.add(calenderDay)

        for (i in 1..23) {
            if (count == currentDay)
                count++

            calenderDay = if (count < currentDay) {
                CalenderDay(
                    day = count.toString(),
                    isOpenable = true
                )

            } else {
                CalenderDay(
                    day = count.toString(),
                    isOpenable = false
                )
            }

            daysList.add(calenderDay)

            count++
        }

        daysList.shuffle()

        helper.populateList(daysList)
    }

}