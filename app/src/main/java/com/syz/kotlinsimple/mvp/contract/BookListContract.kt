package com.syz.kotlinsimple.mvp.contract

import com.syz.kotlinsimple.base.IBaseView
import com.syz.kotlinsimple.base.IPresenter
import com.syz.kotlinsimple.mvp.model.bean.BookListBean
import com.syz.kotlinsimple.mvp.model.bean.PlanBean

/**
 * 作者:shiyuzhe on 2018/7/30 14:07
 * 邮箱:18091664559@163.com
 * Desc:
 */
class BookListContract {

    interface View : IBaseView {
        fun setBookLisMore(bookListBeans: ArrayList<BookListBean>)
        fun setBookListData(bookListBeans: ArrayList<BookListBean>)
        /**
         * 显示错误信息
         */
        fun showError(msg: String, errorCode: Int)
    }

    interface Presenter : IPresenter<View> {
        /**
         * 获取书单信息
         */
        fun requestBookListData(string: String)

        /**
         * 加载更多书单信息
         */
        fun loadMoreBookListData(string: String)
    }
}
