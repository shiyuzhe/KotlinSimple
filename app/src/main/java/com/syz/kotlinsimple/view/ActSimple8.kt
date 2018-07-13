package com.syz.kotlinsimple.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.mvp.model.bean.CategoryBean
import java.io.File

/**
 * kotlin 高阶函数
 *
 *
 * 修饰符：inline   减少高阶函数编译过程中临时变量的生成，修饰后变成语句的调用   （增加编译负担，默认只用于修饰高阶函数）
 */
class ActSimple8 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_simple3)
        onlyif(true) {
            Log.e("syz", "打印日志")
        }
        show()
    }

    //高阶函数
    //boolean参数；；参数为空，返回值为Unit的函数（没有返回值的函数，默认返回一个隐藏类型，Unit类型对象）
    fun onlyif(isDebug: Boolean, block: () -> Unit) {
        if (isDebug) block()
    }

    //函数是"一等公民"
    fun show() {
        val runnable = Runnable { Log.e("syz", "Runnable::run") }
        var function: () -> Unit
        function = runnable::run
        onlyif(true, function)

    }

}
