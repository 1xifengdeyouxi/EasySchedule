package com.swu.easyschedule.ui.schedule.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.swu.easyschedule.R
import com.swu.easyschedule.base.BaseActivity
import com.swu.easyschedule.databinding.ActivityMainBinding
import com.swu.easyschedule.ui.schedule.fragment.ScheduleFragment
import com.swu.easyschedule.viewModel.MainActivityViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {
    override val layoutId: Int
        get() = ActivityMainBinding.inflate(layoutInflater).root.id

    override val viewModel: MainActivityViewModel by lazy {
        MainActivityViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openFragment(ScheduleFragment())
    }
}