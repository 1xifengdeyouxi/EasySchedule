package com.swu.easyschedule.ui.schedule.fragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import biweekly.util.DayOfWeek
import com.bumptech.glide.Glide
import com.swu.easyschedule.R
import com.swu.easyschedule.adapter.SchedulePagerAdapter
import com.swu.easyschedule.base.BaseFragment
import com.swu.easyschedule.bean.TableBean
import com.swu.easyschedule.databinding.FragmentScheduleBinding
import com.swu.easyschedule.ui.schedule.activity.MainActivity
import com.swu.easyschedule.utils.Const
import com.swu.easyschedule.utils.CourseUtils
import com.swu.easyschedule.utils.getPrefer
import com.swu.easyschedule.viewmodel.ScheduleViewModel


class ScheduleFragment : BaseFragment<FragmentScheduleBinding, ScheduleViewModel>() {
    override fun layoutId() = R.layout.fragment_schedule

    override fun obtainViewModel(): ScheduleViewModel =  defaultViewModelProviderFactory.create(ScheduleViewModel::class.java)
    // 防止 Insets 多次应用
    private var insetsApplied = false
    // 课程表页面适配器，用于管理ViewPager中的Fragment
    private var mAdapter: SchedulePagerAdapter? = null
    // 懒加载获取预加载设置，用于控制是否预加载课程表页面 LazyThreadSafetyMode代表锁的意思
    private val preLoad by lazy(LazyThreadSafetyMode.NONE) {
        requireActivity().getPrefer().getBoolean(Const.KEY_SCHEDULE_PRE_LOAD, true)
    }
    override fun initView() {
        initBar()
        Glide.with(this).load(R.drawable.main_background_2020_1).into(binding.ankoIvBg)
        initViewPage(30, viewModel.table)
    }

    private fun initViewPage(maxWeek: Int, table: TableBean) {
        if (mAdapter == null) {
            mAdapter = SchedulePagerAdapter(maxWeek, preLoad, requireActivity())
            binding.ankoVp2Schedule.adapter = mAdapter
            binding.ankoVp2Schedule.offscreenPageLimit = 1
//            if (CourseUtils.countWeek(table.startDate, table.sundayFirst) > 0) {
//                binding.ankoVp2Schedule.currentItem = CourseUtils.countWeek(table.startDate, table.sundayFirst) - 1
//            } else {
//                binding.ankoVp2Schedule.currentItem = 0
//            }
        }
    }

    override fun viewBinding(binding: FragmentScheduleBinding, viewModel: ScheduleViewModel) {
    }

    override fun observer() {
    }
    //设置参数：使用Bundle将week和preLoad参数传递给fragment的arguments
//    companion object {
//        @JvmStatic
//        fun newInstance(week: Int, preLoad: Boolean) =
//            ScheduleFragment().apply {
//                arguments = Bundle().apply {
//                    putInt("week", week)
//                    putBoolean("preLoad", preLoad)
//                }
//            }
//    }
    private fun initBar() {
        binding.toolbar.setNavigationIcon(R.drawable.menu)
        binding.toolbar.setTitle("主标题11");
        //  副标题
        binding.toolbar.setSubtitle("副标题22");
        binding.toolbar.inflateMenu(R.menu.app_bar_meun)
        ViewCompat.setOnApplyWindowInsetsListener(binding.appBar) { _ , windowInsets ->
            if (!insetsApplied) {
                // 获取状态栏的高度
                val statusBarHeight = windowInsets.getInsets(WindowInsetsCompat.Type.statusBars()).top
                // 增加 Toolbar 的物理高度，让它有足够空间
                val toolbar = binding.toolbar
                val originalToolbarHeight = toolbar.layoutParams.height
                toolbar.layoutParams.height = originalToolbarHeight + statusBarHeight
                // 为 Toolbar 设置顶部内边距
                toolbar.setPadding(toolbar.paddingLeft, statusBarHeight, toolbar.paddingRight, toolbar.paddingBottom)
                // 为 CollapsingToolbarLayout 设置最小高度，以适应 Toolbar
                //binding.collapsingToolbar.minimumHeight = originalToolbarHeight + statusBarHeight
                insetsApplied = true
            }
            windowInsets
        }
        binding.toolbar.setNavigationOnClickListener {
            binding.ankoDrawerLayout.openDrawer(GravityCompat.START)
            Toast.makeText(requireContext(), "start", Toast.LENGTH_SHORT).show()
        }
        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_add_class -> {
                    Toast.makeText(requireContext(), "menu_add_class", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.menu_download_class -> {
                    Toast.makeText(requireContext(), "menu_download_class", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.menu_share -> {
                    Toast.makeText(requireContext(), "menu_share", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.menu_more -> {
                    Toast.makeText(requireContext(), "menu_more", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
            }
            true
        }
    }
}