package com.swu.easyschedule.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter4.BaseQuickAdapter
import com.chad.library.adapter4.viewholder.QuickViewHolder
import com.google.android.material.internal.ViewUtils.dpToPx
import com.swu.easyschedule.R
import com.swu.easyschedule.bean.CourseBean

class CourseAdapter(val layoutResId: Int, val data: MutableList<CourseBean>) :
    BaseQuickAdapter<CourseBean, QuickViewHolder>(data) {
    private val fixedColumnWidth = 60 // 固定行的高度（dp）
    override fun onBindViewHolder(holder: QuickViewHolder, position: Int, item: CourseBean?) {
        // 根据位置设置不同高度
        val params = holder.itemView.layoutParams
        if (data.size % position == 0) {
            // 固定设置固定高度
        } else {
            // 其他行设置为0，让其按权重分配
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        }
        holder.itemView.layoutParams = params
        holder.setText(R.id.item_text, item?.courseName)
        holder.setText(R.id.item_text1, item?.day.toString())
    }

    override fun onCreateViewHolder(context: Context, parent: ViewGroup, viewType: Int): QuickViewHolder {
        return QuickViewHolder(layoutResId, parent)
    }
    // 视图持有者
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.item_text)
    }
}