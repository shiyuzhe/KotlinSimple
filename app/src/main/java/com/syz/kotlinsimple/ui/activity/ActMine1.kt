package com.syz.kotlinsimple.ui.activity

import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.base.BaseActivity

const val a = 0
class ActMine1 : BaseActivity() {
    override fun layoutId(): Int = R.layout.act_mine1

    override fun initData() {
    }

    override fun initView() {
    }

    override fun start() {
    }


    var string: String? = null
        get() = field + "-get"
        set(value) {
            field = value + "-set"
        }

    val string2: String? = null
        get() = field + "-get"
}
