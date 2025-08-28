package com.swu.easyschedule.ui.schedule.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.swu.easyschedule.R
import com.swu.easyschedule.base.BaseFragment
import com.swu.easyschedule.databinding.FragmentScheduleBinding
import com.swu.easyschedule.ui.schedule.activity.MainActivity
import com.swu.easyschedule.viewmodel.ScheduleViewModel


class ScheduleFragment : BaseFragment<FragmentScheduleBinding, ScheduleViewModel>() {
    override fun layoutId() = R.layout.fragment_schedule

    override fun obtainViewModel(): ScheduleViewModel = defaultViewModelProviderFactory.create(ScheduleViewModel::class.java)
    // 防止 Insets 多次应用
    private var insetsApplied = false
    override fun initView() {
        initBar()

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.app_bar_meun, menu)
    }


    override fun viewBinding(binding: FragmentScheduleBinding, viewModel: ScheduleViewModel) {
    }

    override fun observer() {
    }
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
//        binding.toolbar.setOnMenuItemClickListener {
//
//        }
    }
}