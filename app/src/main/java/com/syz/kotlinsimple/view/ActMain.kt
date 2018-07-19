package com.syz.kotlinsimple.view

import android.widget.Toast
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.base.BaseActivity
import kotlinx.android.synthetic.main.act_main.*

class ActMain : BaseActivity() {
    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun layoutId(): Int = R.layout.act_main

    override fun initData() {
    }

    override fun initView() {
        act_view.text = "Kotlin act_view"
        act_view.setOnClickListener {
            showToast(act_view.text.toString())
//            startActivity(Intent(ActMain::getApplicationContext, ActView::class))
        }
    }


    private fun showToast(str: String): String {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
        return str
    }
}
