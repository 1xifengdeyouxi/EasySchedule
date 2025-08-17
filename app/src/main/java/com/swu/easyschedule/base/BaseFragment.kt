package com.swu.easyschedule.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.swu.easyschedule.R
import com.swu.easyschedule.utils.BR

abstract class BaseFragment<T : ViewDataBinding, M : BaseViewModel> :Fragment(){
    abstract val layoutId: Int
    lateinit var databinding: T
    abstract val viewModel: M
    open val isChildFragment: Boolean = false
    var mHavePID = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        databinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        databinding.setVariable(BR.vm, viewModel)
        databinding.lifecycleOwner = this
        initView()
        initData()
        return databinding.root
    }

    open fun initView(){}
    open fun initData(){}

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
}