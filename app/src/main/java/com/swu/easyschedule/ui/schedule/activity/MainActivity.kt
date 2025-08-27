package com.swu.easyschedule.ui.schedule.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.swu.easyschedule.R
import com.swu.easyschedule.base.BaseActivity
import com.swu.easyschedule.databinding.ActivityMainBinding
import com.swu.easyschedule.ui.schedule.fragment.ScheduleFragment
import com.swu.easyschedule.viewmodel.MainActivityViewModel
import kotlin.getValue

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>(), View.OnClickListener {
    override fun layoutId() = R.layout.activity_main
    override fun obtainViewModel(): MainActivityViewModel = defaultViewModelProviderFactory.create(MainActivityViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openFragment(ScheduleFragment())
    }

    override fun viewBinding(binding: ActivityMainBinding, viewModel: MainActivityViewModel) {
    }

    override fun observer() {
    }

    override fun onClick(v: View?) {
    }
}