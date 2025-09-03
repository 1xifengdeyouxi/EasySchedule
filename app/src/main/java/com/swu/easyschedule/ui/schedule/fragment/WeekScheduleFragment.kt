package com.swu.easyschedule.ui.schedule.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.chad.library.adapter4.BaseQuickAdapter
import com.chad.library.adapter4.viewholder.QuickViewHolder
import com.swu.easyschedule.R
import com.swu.easyschedule.adapter.CourseAdapter
import com.swu.easyschedule.base.BaseFragment
import com.swu.easyschedule.bean.CourseBean
import com.swu.easyschedule.databinding.FragmentWeekScheduleBinding
import com.swu.easyschedule.viewmodel.ScheduleViewModel
import es.dmoral.toasty.Toasty


class WeekScheduleFragment : BaseFragment<FragmentWeekScheduleBinding, ScheduleViewModel>() {
    private var currentWeek = 1 // 当前周数
    private var courseDateList: MutableList<CourseBean> = mutableListOf()
    private val fixedColumnIndex = 0 // 要固定高度的行索引（第一行）
    private val fixedColumnWidth = 100 // 固定行的高度（dp）
    private var adapter = object : BaseQuickAdapter<CourseBean, QuickViewHolder>(courseDateList) {
        override fun onBindViewHolder(holder: QuickViewHolder, position: Int, item: CourseBean?) {
            // 根据位置设置不同高度
            val params = holder.itemView.layoutParams
            Log.d(TAG, "courseDateList大小：${courseDateList.size}")
            Log.d(TAG, "查看位置：${courseDateList.size % 8}")
            if (position % 8 == 0) {
                // 固定设置固定宽度
                Log.d(TAG, "位置： $position 固定行高度：${dpToPx(fixedColumnWidth)}px")
                params.width = dpToPx(fixedColumnWidth)
                holder.itemView.setBackgroundResource(R.color.black)
            } else {
                // 其他行设置为0，让其按权重分配
                params.width = ViewGroup.LayoutParams.MATCH_PARENT
            }
            holder.itemView.layoutParams = params
            holder.setText(R.id.item_text, item?.courseName)
            holder.setText(R.id.item_text1, item?.day.toString())
        }
        override fun onCreateViewHolder(context: Context, parent: ViewGroup, viewType: Int): QuickViewHolder {
            return QuickViewHolder(R.layout.item_schedule_fixed_column, parent)
        }
    }

    var course: CourseBean = CourseBean(
        id = 1,
        courseName = "ad",
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
        for(i in 0..10){
            courseDateList.add(
                CourseBean(
                    id = i + 1,
                    courseName = "课程 ${i + 1}",
                    day = i % 8,
                    room = "教室 ${i % 5 + 1}",
                    teacher = "教师 ${i % 3 + 1}",
                    startNode = 1,
                    step = 2,
                    startWeek = 1,
                    endWeek = 16,
                    type = 1,
                    color = "#666666",
                    tableId = 1
                )
            )
        }
        Toasty.info(requireContext(), "courseDateList：${courseDateList.size}").show()
//        adapter = CourseAdapter(R.layout.item_schedule_fixed_column,courseDateList) // 需自定义课程适配器
//        adapter.addAll(courseDateList)
        // 设置网格布局管理器，3列
        val layoutManager = GridLayoutManager(requireContext(), 8)
        binding.courseRecyclerView.layoutManager = layoutManager
        binding.courseRecyclerView.adapter = adapter
    }

    companion object {
        fun newInstance(week: Int) = WeekScheduleFragment().apply {
            arguments = Bundle().apply {
                putInt("week", week)
            }
        }
        private val TAG = "WeekScheduleFragment"
    }
    // dp转px工具方法
    private fun dpToPx(dp: Int): Int {
        val density = resources.displayMetrics.density
        return (dp * density + 0.5f).toInt()
    }
}