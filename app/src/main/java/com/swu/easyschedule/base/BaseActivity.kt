package com.swu.easyschedule.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding, M : BaseViewModel> : AppCompatActivity() {
    abstract val layoutId: Int
    abstract val viewModel: M

    val databinding: T by lazy {
        DataBindingUtil.setContentView(this, layoutId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding.lifecycleOwner = this
        databinding.setVariable(BR.vm, viewModel)
        initView()
        initData()
    }
}