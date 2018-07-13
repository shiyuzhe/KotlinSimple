package com.syz.kotlinsimple.mvp.contract

import com.syz.kotlinsimple.base.IBaseView
import com.syz.kotlinsimple.base.IPresenter


/**

 * 作者:shiyuzhe on 2018/7/11 17:01
 * 邮箱:18091664559@163.com
 * Desc:
 */
interface HomeContract{

    interface View : IBaseView {

        /**
         * 设置第一次请求的数据
         */
//        fun setHomeData(homeBean: HomeBean)

        /**
         * 设置加载更多的数据
         */
//        fun setMoreData(itemList:ArrayList<HomeBean.Issue.Item>)

        /**
         * 显示错误信息
         */
        fun showError(msg: String,errorCode:Int)


    }

    interface Presenter : IPresenter<View> {

        /**
         * 获取首页精选数据
         */
        fun requestHomeData(num: Int)

        /**
         * 加载更多数据
         */
        fun loadMoreData()


    }

}
