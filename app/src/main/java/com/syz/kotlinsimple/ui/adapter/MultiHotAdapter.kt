package com.syz.kotlinsimple.ui.adapter

import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.mvp.model.bean.BookListBean
import com.syz.kotlinsimple.view.recyclerview.MultipleType

/**

 * 作者:shiyuzhe on 2018/7/31 17:38
 * 邮箱:18091664559@163.com
 * Desc:
 */
class MultiHotAdapter : MultipleType<BookListBean> {
    override fun getLayoutId(item: BookListBean, position: Int): Int = R.layout.item_hot
}