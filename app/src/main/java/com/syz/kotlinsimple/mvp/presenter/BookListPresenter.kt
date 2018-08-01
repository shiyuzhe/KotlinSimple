package com.syz.kotlinsimple.mvp.presenter

import com.syz.kotlinsimple.base.BasePresenter
import com.syz.kotlinsimple.mvp.contract.BookListContract
import com.syz.kotlinsimple.mvp.model.BookModel
import com.syz.kotlinsimple.mvp.model.bean.BookBean
import com.syz.kotlinsimple.mvp.model.bean.BookListBean
import com.syz.kotlinsimple.net.exception.ExceptionHandle

/**
 * 作者:shiyuzhe on 2018/7/30 14:10
 * 邮箱:18091664559@163.com
 * Desc:
 */
class BookListPresenter : BasePresenter<BookListContract.View>(), BookListContract.Presenter {
    private val bookModel: BookModel by lazy {
        BookModel()
    }

    var canLoadMore: Boolean = true

    override fun requestBookListData(string: String) {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = bookModel.requestBookListData(string)
            .subscribe(
                { t: ArrayList<BookListBean> ->
                    mRootView?.apply {
                        dismissLoading()
                        setBookListData(t)
                    }
                },
                { t: Throwable ->
                    mRootView?.showError(
                        ExceptionHandle.handleException(t),
                        ExceptionHandle.errorCode
                    )
                })
        if (disposable != null) {
            addSubscription(disposable)
        }
    }

    override fun loadMoreBookListData(string: String) {
        if (canLoadMore) {
            val disposable = bookModel.requestBookListData(string)
                .subscribe(
                    { t: ArrayList<BookListBean> ->
                        mRootView?.apply {
                            //t.takeIf { it.isEmpty() }?.also { setBookListData(it)}
//                            t.takeUnless { it.isEmpty() }?.also {
//                                canLoadMore = false }
//                                    ?: setBookLisMore(t)
                            setBookLisMore(t)
//                            if (t.isEmpty()) {
//                                canLoadMore = false
//                            } else {
//                                setBookListData(t)
//                            }
                        }
                    },
                    { t: Throwable ->
                        mRootView?.showError(
                            ExceptionHandle.handleException(t),
                            ExceptionHandle.errorCode
                        )
                    })
            if (disposable != null) {
                addSubscription(disposable)
            }
        }

    }
}