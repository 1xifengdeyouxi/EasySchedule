package com.swu.easyschedule.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.swu.easyschedule.R
import com.swu.easyschedule.utils.BR

abstract class BaseFragment<V : ViewDataBinding, VM : BaseViewModel> :Fragment(){
    protected lateinit var binding: V
    protected val viewModel: VM by lazy {
        obtainViewModel()
    }
    protected abstract fun layoutId(): Int
    protected abstract fun obtainViewModel(): VM

    private var isFirst: Boolean = true // 是否第一次加载
    /**
     * 处理登出操作。
     * 当用户需要登出时，调用此方法。
     */
    open fun loginOut() {
        // 在这里处理登出逻辑，例如清除用户信息、关闭会话等
    }
//    // 页面状态同时只能展示一个
//    private val loadingFeature: ViewBoundFeatureWrapper<LoadingFeature> = ViewBoundFeatureWrapper()
//    private val errorFeature: ViewBoundFeatureWrapper<ErrorFeature> = ViewBoundFeatureWrapper()
//    private val emptyFeature: ViewBoundFeatureWrapper<EmptyFeature> = ViewBoundFeatureWrapper()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        isFirst = true
        binding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        binding.lifecycleOwner = viewLifecycleOwner
//        initErrorFeature(binding.root)
//        initLoadingFeature(binding.root)
//        initEmptyFeature(binding.root)
        observer()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        if (lifecycle.currentState == Lifecycle.State.STARTED && isFirst) {
            viewBinding(binding, viewModel)
            isFirst = false
        } else {
            onReStart(binding, viewModel)
        }
    }

    protected abstract fun viewBinding(binding: V, viewModel: VM)
    protected abstract fun observer()
    open fun onReStart(binding: V, viewModel: VM) {}

//    open fun initView(){}
//    open fun initData(){}


    //创建打开新的fragment界面
    fun openFragment(fragment: Fragment, tag: String = fragment.tag.toString()) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .addToBackStack(fragment.tag)
            .replace(
                R.id.content,
                fragment,
                tag,
            )
            .commit()
    }


    fun openFragmentAllowLoss(fragment: Fragment, tag: String = fragment.tag.toString()) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .addToBackStack(fragment.tag)
            .replace(
                R.id.content,
                fragment,
                tag,
            )
            .commitAllowingStateLoss()
    }
    override fun onDestroy() {
        super.onDestroy()
        isFirst = false
    }
}