package com.swu.easyschedule.ui.schedule.activity

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.activity.enableEdgeToEdge
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
        //解除应用内容与系统 UI 区域的 “隔离”，让界面从屏幕顶部边缘（状态栏）延伸到底部边缘（导航栏）
        // 配合半透明的系统 UI 实现更现代、更沉浸式的视觉效果。
        enableEdgeToEdge()
        openFragment(ScheduleFragment())
    }

    override fun viewBinding(binding: ActivityMainBinding, viewModel: MainActivityViewModel) {
    }

    override fun observer() {
    }

    override fun onClick(v: View?) {
    }
}