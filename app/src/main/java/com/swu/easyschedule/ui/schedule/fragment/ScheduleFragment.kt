package com.swu.easyschedule.ui.schedule.fragment

import com.swu.easyschedule.R
import com.swu.easyschedule.base.BaseFragment
import com.swu.easyschedule.databinding.FragmentScheduleBinding
import com.swu.easyschedule.viewmodel.ScheduleViewModel


class ScheduleFragment : BaseFragment<FragmentScheduleBinding, ScheduleViewModel>() {
    override fun layoutId() = R.layout.fragment_schedule

    override fun obtainViewModel(): ScheduleViewModel = defaultViewModelProviderFactory.create(ScheduleViewModel::class.java)

    override fun viewBinding(binding: FragmentScheduleBinding, viewModel: ScheduleViewModel) {
    }

    override fun observer() {
    }
}