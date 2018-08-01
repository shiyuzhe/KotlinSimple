package com.syz.kotlinsimple.mvp.presenter

import com.syz.kotlinsimple.base.BasePresenter
import com.syz.kotlinsimple.mvp.contract.BookContract
import com.syz.kotlinsimple.mvp.model.BookModel
import com.syz.kotlinsimple.mvp.model.bean.BookBean
import com.syz.kotlinsimple.mvp.model.bean.PlanBean
import com.syz.kotlinsimple.net.exception.ExceptionHandle


/**
 * Created by xuhao on 2017/11/8.
 * 首页精选的 Presenter
 * (数据是 Banner 数据和一页数据组合而成的 HomeBean,查看接口然后在分析就明白了)
 */

class BookPresenter : BasePresenter<BookContract.View>(), BookContract.Presenter {
    override fun requestBookData(string: String) {
        // 检测是否绑定 View
        checkViewAttached()
        val disposable = bookModel.requestBookData(string).subscribe({ bookBean: BookBean
            ->
            mRootView?.setBookData(bookBean)
        }, { t: Throwable ->
            mRootView?.showError(ExceptionHandle.handleException(t), ExceptionHandle.errorCode)
        }
        )
        if (disposable != null) {
            addSubscription(disposable)
        }
    }

    override fun requestPlanData(string: String) {
        // 检测是否绑定 View
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = bookModel.requestPlanData(string).subscribe({ bookBean: PlanBean
            ->
            mRootView?.dismissLoading()
            mRootView?.setPlanData(bookBean)
        }, { t: Throwable ->
            mRootView?.dismissLoading()
            mRootView?.showError(ExceptionHandle.handleException(t), ExceptionHandle.errorCode)
        }
        )
        if (disposable != null) {
            addSubscription(disposable)
        }
    }

    private val bookModel: BookModel by lazy {
        BookModel()
    }


}