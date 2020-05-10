package com.github.kiranshny.horizontalbottomnavigationview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HorizontalBottomNavigationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BottomNavigationView(context, attrs, defStyleAttr) {

    private val navMenuView: BottomNavigationMenuView? =
        getChildAt(0) as BottomNavigationMenuView

    //dashboard
    private val dashboardItemView: BottomNavigationItemView? =
        navMenuView?.getChildAt(0) as BottomNavigationItemView
    private val dashboardItemLayout = LayoutInflater.from(context)
        .inflate(R.layout.tab, null, false)
    private val dashboardTv = dashboardItemLayout.findViewById<TextView>(R.id.textviewTitle)
    private val dashboardIcon =
        dashboardItemLayout.findViewById<AppCompatImageView>(R.id.imageViewTab)

    //chats
    private val chatsItemView: BottomNavigationItemView? =
        navMenuView?.getChildAt(1) as BottomNavigationItemView
    private val chatsItemLayout = LayoutInflater.from(context)
        .inflate(R.layout.tab, null, false)
    private val chatTv = chatsItemLayout.findViewById<TextView>(R.id.textviewTitle)
    private val chatIcon = chatsItemLayout.findViewById<AppCompatImageView>(R.id.imageViewTab)

    //workOrder
    private val workOrderItemView: BottomNavigationItemView? =
        navMenuView?.getChildAt(2) as BottomNavigationItemView
    private val workOrderItemLayout = LayoutInflater.from(context)
        .inflate(R.layout.tab, null, false)
    private val workOrderTv = workOrderItemLayout.findViewById<TextView>(R.id.textviewTitle)
    private val workOrderIcon =
        workOrderItemLayout.findViewById<AppCompatImageView>(R.id.imageViewTab)

    //more
    private val moreItemView: BottomNavigationItemView? =
        navMenuView?.getChildAt(3) as BottomNavigationItemView
    private val moreItemLayout = LayoutInflater.from(context)
        .inflate(R.layout.tab_no_name, null, false)
    private val moreIcon = moreItemLayout.findViewById<AppCompatImageView>(R.id.imageViewMore)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        dashboardTv.text = context.getString(R.string.title_dashboard)
        chatTv.text = context.getString(R.string.title_chats)
        workOrderTv.text = context.getString(R.string.title_work_order)
    }

    fun setSelectedItem(position: Int) {
        when (position) {
            0 -> {
                dashboardIcon.setImageResource(R.drawable.ic_tab_dashboard_white)
                chatIcon.setImageResource(android.R.color.transparent)
                workOrderIcon.setImageResource(android.R.color.transparent)
                moreIcon.setImageResource(R.drawable.ic_more)
                dashboardTv.setTypeface(Typeface.DEFAULT_BOLD)
                chatTv.setTypeface(Typeface.DEFAULT)
                workOrderTv.setTypeface(Typeface.DEFAULT)
            }
            1 -> {
                dashboardIcon.setImageResource(android.R.color.transparent)
                chatIcon.setImageResource(R.drawable.ic_chat)
                workOrderIcon.setImageResource(android.R.color.transparent)
                moreIcon.setImageResource(R.drawable.ic_more)
                dashboardTv.setTypeface(Typeface.DEFAULT)
                chatTv.setTypeface(Typeface.DEFAULT_BOLD)
                workOrderTv.setTypeface(Typeface.DEFAULT)
            }
            2 -> {
                dashboardIcon.setImageResource(android.R.color.transparent)
                chatIcon.setImageResource(android.R.color.transparent)
                workOrderIcon.setImageResource(R.drawable.ic_work_order_icon)
                moreIcon.setImageResource(R.drawable.ic_more)
                dashboardTv.setTypeface(Typeface.DEFAULT)
                chatTv.setTypeface(Typeface.DEFAULT)
                workOrderTv.setTypeface(Typeface.DEFAULT_BOLD)
            }
            3 -> {
                dashboardIcon.setImageResource(android.R.color.transparent)
                chatIcon.setImageResource(android.R.color.transparent)
                workOrderIcon.setImageResource(android.R.color.transparent)
                moreIcon.setImageResource(R.drawable.ic_more_white_background)
                dashboardTv.setTypeface(Typeface.DEFAULT)
                chatTv.setTypeface(Typeface.DEFAULT)
                workOrderTv.setTypeface(Typeface.DEFAULT)
            }
        }
        dashboardItemView?.removeAllViews()
        dashboardItemView?.addView(dashboardItemLayout)

        chatsItemView?.removeAllViews()
        chatsItemView?.addView(chatsItemLayout)

        workOrderItemView?.removeAllViews()
        workOrderItemView?.addView(workOrderItemLayout)

        moreItemView?.removeAllViews()
        moreItemView?.addView(moreItemLayout)
    }

    override fun setOnNavigationItemSelectedListener(listener: OnNavigationItemSelectedListener?) {

    }
}
