package com.syz.kotlinsimple.ui.adapter

import android.os.AsyncTask
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.mvp.model.bean.BookListBean

/**

 * 作者:shiyuzhe on 2018/7/31 19:04
 * 邮箱:18091664559@163.com
 * Desc:
 */
class QuickAdapter(data: MutableList<BookListBean>?) :
    BaseQuickAdapter<BookListBean, BaseViewHolder>(R.layout.item_hot, data) {

    override fun convert(helper: BaseViewHolder?, item: BookListBean) {
    helper?.setText(R.id.item_hot_text,item.toString())
    }
}