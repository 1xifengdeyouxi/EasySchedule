package com.swu.easyschedule.ui.schedule.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.swu.easyschedule.R
import com.swu.easyschedule.base.BaseFragment
import com.swu.easyschedule.databinding.FragmentScheduleBinding
import com.swu.easyschedule.viewModel.ScheduleViewModel


class ScheduleFragment : BaseFragment<FragmentScheduleBinding, ScheduleViewModel>() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override val layoutId: Int get() = R.layout.fragment_schedule
    override val viewModel: ScheduleViewModel by lazy {
        ScheduleViewModel()
    }
}