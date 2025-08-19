package com.swu.easyschedule.ui.schedule.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.swu.easyschedule.R
import com.swu.easyschedule.base.BaseFragment
import com.swu.easyschedule.databinding.FragmentScheduleBinding
import com.swu.easyschedule.viewmodel.MainActivityViewModel
import com.swu.easyschedule.viewModel.ScheduleViewModel


class ScheduleFragment : BaseFragment<FragmentScheduleBinding, ScheduleViewModel>() {
    override val layoutId: Int get() = R.layout.fragment_schedule
    override val viewModel by viewModels<MainActivityViewModel>()
}