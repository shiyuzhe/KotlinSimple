package com.syz.kotlinsimple.base

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast


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

    fun BaseActivity.toast(message: CharSequence = "null", duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

}
