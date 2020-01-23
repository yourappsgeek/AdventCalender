package com.yourappsgeek.adventcalender.utils

import android.content.Context
import android.util.DisplayMetrics


/**
 * @CreatedBy Ali Ahsan
 *         Author Email: info.aliuetian@gmail.com
 *         Created on: 2020-01-22
 */
class NoOfColumnsUtil {

    /**
     *  define the function inside the companion object to
     *  tied it to class rather than to instance
     */
    companion object Factory {
        /**
         * Its calculate the no. of columns allowed on current
         * screen by using given column width.
         *
         * @param context current activity context
         * @param columnWidthInDp default column width
         * @return no. of columns allowed on current screen
         */
        fun calculateNoOfColumns(
            context: Context, columnWidthInDp: Float
        ): Int {
            // get current screen metrics
            val displayMetrics: DisplayMetrics = context.resources.displayMetrics

            // get current width in dp by dividing metrics with current screen's density
            val screenWidthInDp = displayMetrics.widthPixels / displayMetrics.density

            // return No. of columns allowed on current screen
            return (screenWidthInDp / columnWidthInDp + 0.5).toInt()
        }
    }
}