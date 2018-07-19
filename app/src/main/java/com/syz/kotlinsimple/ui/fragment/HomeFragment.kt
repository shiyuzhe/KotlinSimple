package com.syz.kotlinsimple.ui.fragment

import android.os.Bundle
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.base.BaseFragment
import com.syz.kotlinsimple.mvp.contract.HomeContract

/**

 * 作者:shiyuzhe on 2018/7/19 17:13
 * 邮箱:18091664559@163.com
 * Desc:
 */
class HomeFragment : BaseFragment(), HomeContract.View {
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
    }

    override fun lazyLoad() {
    }

    override fun showError(msg: String, errorCode: Int) {
    }

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }

}