package com.swu.easyschedule.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * BaseViewModel 类型
 * @author: 1xifengdeyouxi
 * @time: 2025/8/11 10:14
 */
class BaseViewModel : ViewModel() {
    val showLoading: MutableLiveData<Boolean> = MutableLiveData()
}