package com.syz.kotlinsimple.ui.fragment

import android.os.Bundle
import com.orhanobut.logger.Logger
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.base.BaseFragment
import com.syz.kotlinsimple.mvp.contract.BookContract
import com.syz.kotlinsimple.mvp.model.bean.BookBean
import com.syz.kotlinsimple.mvp.model.bean.PlanBean
import com.syz.kotlinsimple.mvp.presenter.BookPresenter
import com.syz.kotlinsimple.net.exception.ErrorStatus
import kotlinx.android.synthetic.main.act_book.*
import kotlinx.android.synthetic.main.fra_hot.*
import java.util.*

/**

 * 作者:shiyuzhe on 2018/7/19 17:13
 * 邮箱:18091664559@163.com
 * Desc:
 */
class HomeFragment : BaseFragment(), BookContract.View {
    override fun setBookData(bookBean: BookBean) {

    }

    override fun setPlanData(planBean: PlanBean) {
        textView2.text = planBean.toString()
    }

    private val mPresenter by lazy { BookPresenter() }

    private var mTitle: String? = null


    companion object {
        fun getInstance(title: String): HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    override fun getLayoutId(): Int = R.layout.act_book

    override fun initView() {
        mPresenter.attachView(this)
        mLayoutStatusView = actBook
        textView2.text = mTitle
    }

    override fun lazyLoad() {
        val date = Date()
        Logger.e("HomeFragment：当前事件：${date.minutes}分${date.seconds}秒")
//        mPresenter.requestPlanData("24772")
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