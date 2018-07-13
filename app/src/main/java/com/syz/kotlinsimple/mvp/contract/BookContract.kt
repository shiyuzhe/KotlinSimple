package com.syz.kotlinsimple.mvp.contract

import com.syz.kotlinsimple.base.IBaseView
import com.syz.kotlinsimple.base.IPresenter
import com.syz.kotlinsimple.mvp.model.bean.BookBean


/**

 * 作者:shiyuzhe on 2018/7/11 17:01
 * 邮箱:18091664559@163.com
 * Desc:
 */
interface BookContract {

    interface View : IBaseView {

        /**
         * 设置第一次请求的数据
         */
        fun setBookData(bookBean: BookBean)


        /**
         * 显示错误信息
         */
        fun showError(msg: String, errorCode: Int)


    }

    interface Presenter : IPresenter<View> {

        /**
         * 获取首页精选数据
         */
        fun requestBookData(string: String)


    }

}
