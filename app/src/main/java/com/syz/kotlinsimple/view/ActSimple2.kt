package com.syz.kotlinsimple.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.syz.kotlinsimple.R

/**
 * 基础语法
 */
class ActSimple2 : AppCompatActivity() {

    //var可变，val不可变
    var age: Int = 18
    var name: String = "Shi Yuzhe"
    //类型检测：通过18推断出age2是Int类型
    var age2 = 18
    val name2 = "Shi Yuzhe"
    //空安全 <?> 不确定是否为空时使用？表示可以为空  String String?
    var name3: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_simple2)
        //<!!>标识强转，确定name3不会为空，就可以直接强转
        name = name3!!
        name3 = name
    }

    fun show(string: String): String {
        //kotlin模版语法
        val str: String = "这个字符串是$string"
        return str
    }



}
