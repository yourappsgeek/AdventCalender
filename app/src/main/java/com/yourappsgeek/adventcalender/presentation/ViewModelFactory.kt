package com.yourappsgeek.adventcalender.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @CreatedBy Ali Ahsan
 *         Author Email: info.aliuetian@gmail.com
 *         Created on: 2020-01-22
 *
 * Base viewModel factory to generate the viewModels from one place
 *
 * @param helper A reference to main UI activity
 */

class ViewModelFactory(private val helper: MainHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(helper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}