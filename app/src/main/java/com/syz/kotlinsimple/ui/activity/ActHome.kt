package com.syz.kotlinsimple.ui.activity

import android.support.v4.app.FragmentTransaction
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.base.BaseActivity
import com.syz.kotlinsimple.ui.fragment.Fragment2
import com.syz.kotlinsimple.ui.fragment.Fragment3
import com.syz.kotlinsimple.ui.fragment.Fragment4
import com.syz.kotlinsimple.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.act_home.*

/**

 * 作者:shiyuzhe on 2018/7/19 16:22
 * 邮箱:18091664559@163.com
 * Desc:
 */
class ActHome : BaseActivity() {
    override fun initView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val mTitles = arrayOf("每日精选", "发现", "热门", "我的")
    //默认为0
    private var mIndex = 0
    private var mHomeFragment: HomeFragment? = null
    private var mFragment2: Fragment2? = null
    private var mFragment3: Fragment3? = null
    private var mFragment4: Fragment4? = null
//    private val frgs: MutableList<BaseFragment> = mutableListOf(HomeFragment(), HomeFragment())
//    private var fragments: List<BaseFragment>? = null

    override fun layoutId(): Int = R.layout.act_home

    override fun initData() {
    }

//    private fun switchFragment(position: Int) {
//        val transaction = supportFragmentManager.beginTransaction()
//        hideFragments(transaction)
//        when (position) {
//            0 // 首页
//            -> mHomeFragment?.let {
//                transaction.show(it)
//            } ?: HomeFragment.getInstance(mTitles[position]).let {
//                mHomeFragment = it
//                transaction.add(R.id.fl_container, it, "home")
//            }
//            1  //发现
//            -> mFragment2?.let {
//                transaction.show(it)
//            } ?: DiscoveryFragment.getInstance(mTitles[position]).let {
//                mFragment2 = it
//                transaction.add(R.id.fl_container, it, "discovery")
//            }
//            2  //热门
//            -> mFragment3?.let {
//                transaction.show(it)
//            } ?: HotFragment.getInstance(mTitles[position]).let {
//                mFragment3 = it
//                transaction.add(R.id.fl_container, it, "hot")
//            }
//            3 //我的
//            -> mFragment4?.let {
//                transaction.show(it)
//            } ?: MineFragment.getInstance(mTitles[position]).let {
//                mFragment4 = it
//                transaction.add(R.id.fl_container, it, "mine")
//            }
//
//            else -> {
//
//            }
//        }
//
//        mIndex = position
//        tab_layout.currentTab = mIndex
//        transaction.commitAllowingStateLoss()
//    }

    /**
     * 隐藏所有的Fragment
     * @param transaction transaction
     */
    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) }
        mFragment2?.let { transaction.hide(it) }
        mFragment3?.let { transaction.hide(it) }
        mFragment4?.let { transaction.hide(it) }
    }

//    override fun initView() {
//        radio_group.setOnCheckedChangeListener { group, checkedId ->
//            when (checkedId) {
//                R.id.radio1 -> switchFragment(0)
//                R.id.radio2 -> switchFragment(1)
//                R.id.radio3 -> switchFragment(2)
//                R.id.radio4 -> switchFragment(3)
//            }
//        }
//    }

    override fun start() {
    }
}