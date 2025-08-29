package com.swu.easyschedule.bean

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class UpdateInfoBean(
        val id: Int,
        val VersionName: String,
        val VersionInfo: String
) : Parcelable