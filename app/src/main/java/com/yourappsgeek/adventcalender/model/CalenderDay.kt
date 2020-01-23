package com.yourappsgeek.adventcalender.model

import com.yourappsgeek.adventcalender.R

/**
 * @CreatedBy Ali Ahsan
 *         Author Email: info.aliuetian@gmail.com
 *         Created on: 2020-01-22
 *
 *Data class to hold the each calender day
 *
 * day property to old month number
 * currentDay to hold whether its current day or not. Its false by default
 * isOpenable to hold whether its openable or not
 * backgroundColor to hold day's backGround color
 */
data class CalenderDay(
    val day: String,
    val currentDay: Boolean = false,
    var isOpenable: Boolean,
    var backgroundColor: Int = R.color.colorPrimary
)