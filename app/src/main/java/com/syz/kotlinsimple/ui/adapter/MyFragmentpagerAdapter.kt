package com.syz.kotlinsimple.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.syz.kotlinsimple.base.BaseFragment

/**

 * 作者:shiyuzhe on 2018/7/19 17:32
 * 邮箱:18091664559@163.com
 * Desc:
 */
class MyFragmentpagerAdapter : FragmentPagerAdapter {
    private var fragmentList: List<Fragment>? = ArrayList()

    constructor(fm: FragmentManager, fragmentList: List<Fragment>) : super(fm) {
        this.fragmentList = fragmentList
    }


    override fun getItem(position: Int): Fragment {
        return fragmentList!!.get(position)
    }

    override fun getCount(): Int = fragmentList?.size ?: 0
}