package com.swu.easyschedule.bean

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity
data class TimeTableBean(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String = "",
    //1代表true，0代表false
    var sameLen:  Int = 1,
    var courseLen: Int = 50
) {
    @Ignore
    constructor(name: String, sameLen: Int, courseLen: Int) : this(0, name, sameLen, courseLen)
}
