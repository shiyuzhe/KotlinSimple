package com.syz.kotlinsimple.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.syz.kotlinsimple.R

/**
 * java与kotlin互调用
 */
class ActSimple3 : AppCompatActivity() {

    /**
     * 1.语法变化
     * 函数可以直接写在文件里，可以不写在类里边（文件名+KT.函数名）《public static 函数名》
     * 类名不与文件名一致？  怎么改
     * Object 类声明  匿名内部类
     *      JavaMain.class(java code)
     *      JavaMain::class.java(kotlin code)
     *      KotlinMain::class(kotlin code)
     * 2.Kotlin关键字处理
     * 关键字（in...等）
     * 冲突时用''将变量包起来，标识转义
     * JavaMain.'in'
     * JavaMain.userId
     * 3.基本数据类型的处理
     *  没有封装类
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_simple3)
    }
}
