package com.syz.kotlinsimple.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.orhanobut.logger.Logger
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.base.BaseFragment
import com.syz.kotlinsimple.ui.adapter.MyFragmentPagerAdapter
import kotlinx.android.synthetic.main.fra_vp.*
import java.util.*

/**
 * 作者:shiyuzhe on 2018/7/19 18:15
 * 邮箱:18091664559@163.com
 * Desc:
 */
class Fragment2 : BaseFragment() {
    private var mTitle: String? = null
    private var fragments: List<Fragment>? = listOf(
        Fragment4.getInstance("vp1"),
        Fragment4.getInstance("vp2"), Fragment4.getInstance("vp3")
    )

    companion object {
        fun getInstance(title: String): Fragment2 {
            val fragment = Fragment2()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    override fun getLayoutId(): Int = R.layout.fra_vp

    override fun initView() {
        viewPager.offscreenPageLimit = (fragments?.size ?: 2) - 1
        viewPager.adapter = MyFragmentPagerAdapter(childFragmentManager, fragments!!)
        tab.setupWithViewPager(viewPager)
    }

    override fun lazyLoad() {
        val date = Date()
        Logger.e("Fragment2：当前事件：${date.minutes}分${date.seconds}秒")
    }
}