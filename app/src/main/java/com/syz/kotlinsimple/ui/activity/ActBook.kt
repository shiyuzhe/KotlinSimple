package com.syz.kotlinsimple.ui.activity

import com.orhanobut.logger.Logger
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.base.BaseActivity
import com.syz.kotlinsimple.mvp.contract.BookContract
import com.syz.kotlinsimple.mvp.model.bean.BookBean
import com.syz.kotlinsimple.mvp.model.bean.PlanBean
import com.syz.kotlinsimple.mvp.presenter.BookPresenter
import kotlinx.android.synthetic.main.act_book.*

class ActBook : BaseActivity(), BookContract.View {
    override fun setPlanData(planBean: PlanBean) {
        textView2.text = planBean.toString()
        Logger.e("bookBean:$planBean")
    }

    private val mPresenter by lazy { BookPresenter() }

    override fun layoutId(): Int = R.layout.act_book

    override fun initData() {
    }

    override fun initView() {
        mPresenter.attachView(this)
        textView2.setOnClickListener {
            //            mPresenter.requestBookData("237475019")
            mPresenter.requestPlanData("24772")
        }

    }

    override fun setBookData(bookBean: BookBean) {
        textView2.text = bookBean.toString()
        Logger.e("bookBean:$bookBean")
    }

    override fun showError(msg: String, errorCode: Int) {
        Logger.e("errMsg:$msg")
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dismissLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
