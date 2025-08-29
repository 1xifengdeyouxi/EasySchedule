package com.swu.easyschedule.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.swu.easyschedule.ui.schedule.fragment.ScheduleFragment
import com.swu.easyschedule.ui.schedule.fragment.WeekScheduleFragment

class SchedulePagerAdapter(
    var maxWeek: Int,
    private val preLoad: Boolean,
    activity: FragmentActivity
) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        return WeekScheduleFragment.newInstance(position + 1)
    }

    override fun getItemCount(): Int {
        return maxWeek
    }
}
