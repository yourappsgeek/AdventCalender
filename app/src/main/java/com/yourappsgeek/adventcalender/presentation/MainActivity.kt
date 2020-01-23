package com.yourappsgeek.adventcalender.presentation

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.yourappsgeek.adventcalender.R
import com.yourappsgeek.adventcalender.databinding.ActivityMainBinding
import com.yourappsgeek.adventcalender.model.CalenderDay
import com.yourappsgeek.adventcalender.utils.NoOfColumnsUtil

/**
 * @CreatedBy Ali Ahsan
 *         Author Email: info.aliuetian@gmail.com
 *         Created on: 2020-01-22
 *
 * App starting and only activity to bind the with main xml view
 * and populate the list when provided by MainViewModel. and
 * reset the list once user find the current day.
 *
 */
class MainActivity : AppCompatActivity(), MainHelper {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var adapter: CalenderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
           The layout for this activity is a Data Binding layout so it needs to be inflated using
           DataBindingUtil.
        */
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this

        viewModelFactory = ViewModelFactory(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MainViewModel::class.java)

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    /**
     *
     * Callback method which is triggered when viewModel prepare the list to populate the recycleView.
     *
     * Initiate the adapter and set the gridLayoutManager with columns count
     * which is app is calculating using Util method.
     *
     * Used the xml defined animation to provide startup animation and set the adapter to recycleView.
     *
     * @param daysList Calender day's list to hold the dataSet.
     *
     */
    override fun populateList(daysList: MutableList<CalenderDay>) {

        adapter = CalenderAdapter(daysList, this)
        binding.rvCalender.layoutManager = GridLayoutManager(
            this,
            NoOfColumnsUtil.calculateNoOfColumns(this, 95f)
        )

        binding.rvCalender.animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right)
        binding.rvCalender.adapter = adapter
    }

    /**
     *
     * Called when a day other than current but still openable is called, it will
     * then update the corresponding item's data and notify the adapter.
     *
     */
    override fun openCalenderDay(position: Int) {

        adapter.onClick(position)
    }

    /**
     *
     * Called when the current day is clicked which will
     * then update the corresponding item's data and notify the adapter and refresh the whole list
     * after showing the success toast.
     *
     */
    override fun openCurrentDay(position: Int) {
        adapter.onClick(position, currentDay = true)
        Toast.makeText(this, getString(R.string.msg_found_current_day), Toast.LENGTH_LONG).show()
        viewModel.loadList()
    }
}
