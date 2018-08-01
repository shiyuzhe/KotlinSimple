package com.syz.kotlinsimple.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.chad.library.adapter.base.BaseQuickAdapter
import com.orhanobut.logger.Logger
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.base.BaseFragment
import com.syz.kotlinsimple.mvp.contract.BookListContract
import com.syz.kotlinsimple.mvp.model.bean.BookListBean
import com.syz.kotlinsimple.mvp.presenter.BookListPresenter
import com.syz.kotlinsimple.net.exception.ErrorStatus
import com.syz.kotlinsimple.ui.adapter.*
import kotlinx.android.synthetic.main.fra_hot.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * 作者:shiyuzhe on 2018/7/30 12:32
 * 邮箱:18091664559@163.com
 * Desc:
 */
class HotFragment : BaseFragment(), BookListContract.View {


    private val mPresenter by lazy { BookListPresenter() }
    private var mBookListList = ArrayList<BookListBean>()
    //    private val mAdapter by lazy { HotAdapters(context!!, mBookListList, R.layout.item_hot) }
//    private val hotAdapters2 by lazy { HotAdapters2(context!!, mBookListList, MultiHotAdapter()) }
//    private val adapter1 by lazy { Adapter1(context!!, mBookListList) }
    private val adapter by lazy { QuickAdapter(mBookListList) }

    companion object {
        fun getInstance(): HotFragment {
            val fragment = HotFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayoutId(): Int = R.layout.fra_hot

    /**
     * 是否加载更多
     */
    private var loadingMore = false

    override fun initView() {
        mPresenter.attachView(this)
        mLayoutStatusView = fraHot
        mRecyclerView.adapter = adapter
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter.setOnItemClickListener { adapter, view, position ->
            Logger.e("onItemClick: ")
            Toast.makeText(context, "onItemClick$position", Toast.LENGTH_SHORT).show()
        }
        adapter.setOnLoadMoreListener(BaseQuickAdapter.RequestLoadMoreListener {
            Logger.e("当前新增第${count}页")
            if (count >= 3) {
                adapter.loadMoreEnd()
            } else {
                count++
                mPresenter.loadMoreBookListData("1")
            }
        }, mRecyclerView)
//        mRecyclerView.adapter = mAdapter
//        mRecyclerView.adapter = hotAdapters2
//        mRecyclerView.adapter = adapter1
//        mRecyclerView.layoutManager = LinearLayoutManager(context)
//        mRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                val itemCount = mRecyclerView.layoutManager.itemCount
//                val lastVisibleItem =
//                    (mRecyclerView.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
//                if (!loadingMore && lastVisibleItem >= (itemCount * 4 / 5)) {
//                    Logger.e("当前位置：$lastVisibleItem 总数：$itemCount")
//                    loadingMore = true
//                    if (mPresenter.canLoadMore) {
////                        mPresenter.loadMoreBookListData("")
//                    }
//
//                }
//            }
//        })
    }

    override fun lazyLoad() {
        val date = Date()
        Logger.e("HotFragment：当前事件：${date.minutes}分${date.seconds}秒")
        mPresenter.requestBookListData("1")
    }

    var count = 1

    override fun setBookListData(bookListBeans: ArrayList<BookListBean>) {
        loadingMore = false
        mBookListList = bookListBeans
        adapter.replaceData(mBookListList)
        adapter.notifyDataSetChanged()
    }

    override fun setBookLisMore(bookListBeans: ArrayList<BookListBean>) {
        adapter.addData(bookListBeans)
        adapter.loadMoreComplete()
    }

    override fun showError(msg: String, errorCode: Int) {
        mLayoutStatusView?.showError()
        if (errorCode == ErrorStatus.NETWORK_ERROR) {
            mLayoutStatusView?.showNoNetwork()
        } else {
            mLayoutStatusView?.showError()
        }
    }

    override fun showLoading() {
        mLayoutStatusView?.showLoading()
    }

    override fun dismissLoading() {
        mLayoutStatusView?.showContent()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}
