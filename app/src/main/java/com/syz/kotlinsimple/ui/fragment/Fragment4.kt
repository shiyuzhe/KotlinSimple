package com.syz.kotlinsimple.ui.fragment

import android.content.Intent
import android.os.Bundle
import com.orhanobut.logger.Logger
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.base.BaseFragment
import com.syz.kotlinsimple.ui.activity.ActCustom
import com.syz.kotlinsimple.ui.activity.ActMine1
import kotlinx.android.synthetic.main.act_book.*
import java.util.*

/**

 * 作者:shiyuzhe on 2018/7/19 18:15
 * 邮箱:18091664559@163.com
 * Desc:
 */
class Fragment4 : BaseFragment() {
    private var mTitle: String? = null

    companion object {
        fun getInstance(title: String): Fragment4 {
            val fragment = Fragment4()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    override fun getLayoutId(): Int = R.layout.act_book

    override fun initView() {
        textView2.text = mTitle
        textView2.setOnClickListener {
            startActivity(Intent(context, ActMine1::class.java))
        }
        customView.setOnClickListener {
            startActivity(Intent(context, ActCustom::class.java))
        }
    }

    override fun lazyLoad() {
        val date = Date()
        Logger.e("Fragment4：当前事件：${date.minutes}分${date.seconds}秒")
    }
}