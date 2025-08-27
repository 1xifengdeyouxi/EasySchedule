package com.swu.easyschedule.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.swu.easyschedule.R
import com.swu.easyschedule.utils.BR

abstract class BaseActivity<V : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {
    protected lateinit var binding: V
    protected val viewModel: VM by lazy {
        obtainViewModel()
    }
    protected abstract fun layoutId(): Int
    protected abstract fun obtainViewModel(): VM

//    // 页面状态同时只能展示一个
//    // 声明一个ViewBoundFeatureWrapper类型的变量loadingFeature，用于展示loading状态
//    private val loadingFeature: ViewBoundFeatureWrapper<LoadingFeature> = ViewBoundFeatureWrapper()
//    // 声明一个ViewBoundFeatureWrapper类型的变量errorFeature，用于展示error状态
//    private val errorFeature: ViewBoundFeatureWrapper<ErrorFeature> = ViewBoundFeatureWrapper()
//    // 声明一个ViewBoundFeatureWrapper类型的变量emptyFeature，用于展示empty状态
//    private val emptyFeature: ViewBoundFeatureWrapper<EmptyFeature> = ViewBoundFeatureWrapper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId())
        binding.lifecycleOwner = this
        viewBinding(binding, viewModel)
        observer()
    }
    /**
     * 进行数据绑定
     */
    protected abstract fun viewBinding(binding: V, viewModel: VM)
    protected abstract fun observer()

//    open fun initView() {}
//    open fun initData() {}

    //创建打开新的fragment界面
    fun openFragment(fragment: Fragment, tag: String = fragment.tag.toString()) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(fragment.tag)
            .replace(
                R.id.content,
                fragment,
                tag,
            ).commit()
    }

    fun openFragmentAllowLoss(fragment: Fragment, tag: String = fragment.tag.toString()) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(fragment.tag)
            .replace(
                R.id.content,
                fragment,
                tag,
            ).commitAllowingStateLoss()
    }
}