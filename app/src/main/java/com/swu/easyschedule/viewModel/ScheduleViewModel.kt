package com.swu.easyschedule.viewmodel

import com.swu.easyschedule.base.BaseViewModel
import com.swu.easyschedule.bean.TableBean
import kotlin.Int

class ScheduleViewModel : BaseViewModel() {
    var table: TableBean = TableBean(
        id = 0,
        tableName = "",
        nodes = 20,
        background = "",
        timeTable = 1,
        startDate = "2020-02-03",
        maxWeek = 30,
        itemHeight = 56,
        itemAlpha = 60,
        itemTextSize = 12,
        widgetItemHeight = 56,
        widgetItemAlpha = 60,
        widgetItemTextSize = 12,
        strokeColor = 0x80ffffff.toInt(),
        widgetStrokeColor = 0x80ffffff.toInt(),
        textColor = 0xff000000.toInt(),
        widgetTextColor = 0xff000000.toInt(),
        courseTextColor = 0xffffffff.toInt(),
        widgetCourseTextColor = 0xffffffff.toInt(),
        showSat = true,
        showSun = true,
        sundayFirst = false,
        showOtherWeekCourse = true,
        showTime = false,
        type = 0
    )


}