package com.syz.kotlinsimple.ui.adapter

import android.content.Context
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.mvp.model.bean.BookListBean
import com.syz.kotlinsimple.view.recyclerview.MultipleType
import com.syz.kotlinsimple.view.recyclerview.ViewHolder
import com.syz.kotlinsimple.view.recyclerview.adapter.CommonAdapter

/**

 * 作者:shiyuzhe on 2018/7/30 15:50
 * 邮箱:18091664559@163.com
 * Desc:
 */
 class HotAdapters2(context: Context, bookListBeans: ArrayList<BookListBean>, layoutId: MultipleType<BookListBean>) :
    CommonAdapter<BookListBean>(context, bookListBeans, layoutId) {
    fun setData(bookListBeans: ArrayList<BookListBean>) {
        mData.clear()
        mData = bookListBeans
        notifyDataSetChanged()
    }

    override fun bindData(holder: ViewHolder, data: BookListBean, position: Int) {
        holder.getView<TextView>(R.id.item_hot_text).setOnClickListener(View.OnClickListener {
            Toast.makeText(
                mContext,
                "点击第$position 项",
                Toast.LENGTH_SHORT
            ).show()
        })
        holder.setText(R.id.item_hot_text, data.toString())
    }
}