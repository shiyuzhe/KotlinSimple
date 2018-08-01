package com.syz.kotlinsimple.ui.adapter

import android.content.Context
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.syz.kotlinsimple.MyApplication.Companion.context
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.mvp.model.bean.Bean
import com.syz.kotlinsimple.mvp.model.bean.BookListBean
import com.syz.kotlinsimple.view.recyclerview.MultipleType
import com.syz.kotlinsimple.view.recyclerview.ViewHolder
import com.syz.kotlinsimple.view.recyclerview.adapter.CommonAdapter

/**
 * 作者:shiyuzhe on 2018/7/30 15:50
 * 邮箱:18091664559@163.com
 * Desc:
 */
abstract class CommonMultiAdapters<T>(
    context: Context,
    bookListBeans: ArrayList<T>,
    layoutId: MultipleType<T>
) : CommonAdapter<T>(context, bookListBeans, layoutId) where T : Bean {

    override fun bindData(holder: ViewHolder, data: T, position: Int) {
    }

//    abstract fun getType(): MultipleType<T>

    fun setData(beans: ArrayList<T>) {
        mData.clear()
        mData = beans
        notifyDataSetChanged()
    }
}
