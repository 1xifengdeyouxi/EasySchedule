package com.swu.easyschedule.ui.schedule.fragment

import android.os.Bundle
import com.swu.easyschedule.R
import com.swu.easyschedule.adapter.CourseAdapter
import com.swu.easyschedule.base.BaseFragment
import com.swu.easyschedule.bean.CourseBean
import com.swu.easyschedule.bean.TableBean
import com.swu.easyschedule.databinding.FragmentWeekScheduleBinding
import com.swu.easyschedule.viewmodel.ScheduleViewModel
import kotlin.Int

class WeekScheduleFragment : BaseFragment<FragmentWeekScheduleBinding, ScheduleViewModel>() {
    private var currentWeek = 1 // 当前周数
    var course: CourseBean = CourseBean(
        id = 1,
        courseName = "android",
        day = 1,
        room = "biejing",
        teacher = "ushio",
        startNode = 1,
        step = 1,
        startWeek = 1,
        endWeek = 1,
        type = 1,
        color = "#666666",
        tableId = 1
    )

    override fun layoutId(): Int = R.layout.fragment_week_schedule

    override fun obtainViewModel(): ScheduleViewModel {
        return defaultViewModelProviderFactory.create(ScheduleViewModel::class.java)
    }

    override fun viewBinding(binding: FragmentWeekScheduleBinding, viewModel: ScheduleViewModel) {
    }

    override fun observer() {
    }

    override fun initView() {
        // 从参数获取当前周数
        arguments?.getInt("week")?.let {
            currentWeek = it
            binding.weekTitle.text = "第 $currentWeek 周"
        }
        // 加载当前周的课程数据（根据实际业务逻辑实现）
        loadWeekCourses(currentWeek)
    }

    private fun loadWeekCourses(week: Int) {
//        // 示例：从ViewModel获取数据并显示
//        viewModel.getCoursesByWeek(week).observe(viewLifecycleOwner) { courses ->
//            // 这里用RecyclerView或网格布局展示课程
//            val adapter = CourseAdapter(courses) // 需自定义课程适配器
//            binding.courseRecyclerView.adapter = adapter
//        }
        val adapter = CourseAdapter(course) // 需自定义课程适配器
    }

    companion object {
        fun newInstance(week: Int) = WeekScheduleFragment().apply {
            arguments = Bundle().apply {
                putInt("week", week)
            }
        }
    }
}