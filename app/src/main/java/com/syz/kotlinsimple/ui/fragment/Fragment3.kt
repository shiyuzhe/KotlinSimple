package com.syz.kotlinsimple.ui.fragment

import android.os.Bundle
import com.orhanobut.logger.Logger
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.base.BaseFragment
import kotlinx.android.synthetic.main.act_book.*
import java.util.*

/**

 * 作者:shiyuzhe on 2018/7/19 18:15
 * 邮箱:18091664559@163.com
 * Desc:
 */
class Fragment3 : BaseFragment() {
    private var mTitle: String? = null
    companion object {
        fun getInstance(title: String): Fragment3 {
            val fragment = Fragment3()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }
    override fun getLayoutId(): Int = R.layout.act_book

    override fun initView() {
        textView2.text = mTitle
    }

    override fun lazyLoad() {
        val date = Date()
        Logger.e("Fragment3：当前事件：${date.minutes}分${date.seconds}秒")
    }
}