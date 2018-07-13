package com.syz.kotlinsimple.base

import android.support.v7.app.AppCompatActivity
import android.os.Bundle


abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        initData()
        initView()
    }

    abstract fun layoutId(): Int

    abstract fun initData()

    abstract fun initView()
}
