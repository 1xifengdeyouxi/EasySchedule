package com.swu.easyschedule.ui.schedule.activity

import android.os.Bundle
import com.swu.easyschedule.R
import com.swu.easyschedule.base.BaseActivity
import com.swu.easyschedule.databinding.ActivityMainBinding
import com.swu.easyschedule.ui.schedule.fragment.ScheduleFragment
import com.swu.easyschedule.viewmodel.MainActivityViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {
    override val layoutId: Int = R.layout.activity_main

    override val viewModel: MainActivityViewModel by lazy {
        MainActivityViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openFragment(ScheduleFragment())
    }
}