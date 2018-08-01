package com.syz.kotlinsimple.ui.activity

import android.support.v4.app.FragmentTransaction
import android.view.KeyEvent
import android.view.View
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.base.BaseActivity
import com.syz.kotlinsimple.showToast
import com.syz.kotlinsimple.ui.fragment.*
import kotlinx.android.synthetic.main.act_home.*

/**

 * 作者:shiyuzhe on 2018/7/19 16:22
 * 邮箱:18091664559@163.com
 * Desc:
 */
class ActHome : BaseActivity() {

    private val mTitles = arrayOf("每日精选", "发现", "热门", "我的")
    //默认为0
    private var mIndex = 1
    private var mHomeFragment: HomeFragment? = null
    private var mFragment2: Fragment2? = null
    private var hotFragment: HotFragment? = null
    private var mFragment4: Fragment4? = null

    override fun layoutId(): Int = R.layout.act_home

    override fun initData() {
        radio1.text = mTitles[0]
        radio2.text = mTitles[1]
        radio3.text = mTitles[2]
        radio4.text = mTitles[3]
        switchFragment(mIndex)
    }

    private fun switchFragment(position: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        when (position) {
            0 // 首页
            -> mHomeFragment?.let {
                transaction.show(it)
            } ?: HomeFragment.getInstance(mTitles[position]).let {
                mHomeFragment = it
                transaction.add(R.id.fl_container, it, "home")
                inc_top.visibility = View.VISIBLE
            }
            1  //发现
            -> mFragment2?.let {
                transaction.show(it)
            } ?: Fragment2.getInstance(mTitles[position]).let {
                mFragment2 = it
                transaction.add(R.id.fl_container, it, "discovery")
                inc_top.visibility = View.VISIBLE
            }
            2  //热门
            -> hotFragment?.let {
                transaction.show(it)
            } ?: HotFragment.getInstance().let {
                hotFragment = it
                transaction.add(R.id.fl_container, it, "hot")
                inc_top.visibility = View.VISIBLE
            }
            3 //我的
            -> mFragment4?.let {
                transaction.show(it)
            } ?: Fragment4.getInstance(mTitles[position]).let {
                mFragment4 = it
                transaction.add(R.id.fl_container, it, "mine")
                inc_top.visibility = View.GONE
            }

            else -> {

            }
        }

        mIndex = position
        radio_group.check(mIndex)
//        tab_layout.currentTab = mIndex
        transaction.commitAllowingStateLoss()
    }

    /**
     * 隐藏所有的Fragment
     * @param transaction transaction
     */
    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) }
        mFragment2?.let { transaction.hide(it) }
        hotFragment?.let { transaction.hide(it) }
        mFragment4?.let { transaction.hide(it) }
    }

    override fun initView() {
        radio_group.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio1 -> switchFragment(0)
                R.id.radio2 -> switchFragment(1)
                R.id.radio3 -> switchFragment(2)
                R.id.radio4 -> switchFragment(3)
            }
        }
    }

    override fun start() {
    }


    private var mExitTime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis().minus(mExitTime) <= 2000) {
                finish()
            } else {
                mExitTime = System.currentTimeMillis()
                showToast("再按一次退出程序")
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}