package com.syz.kotlinsimple.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.mvp.model.bean.CategoryBean

/**
 * kotlin扩展函数
 */
class ActSimple4 : AppCompatActivity() {

    /**
     * 对第三方类或不可控类做扩展（新增一些需要用的方法）
     * 可扩展：成员函数 成员变量
     */
    var textView: TextView? = null
    var categoryBean: CategoryBean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_simple3)
        categoryBean = CategoryBean(1L, "name", "des", "pic", "col", "img")
//        var file = File("")
        //public fun File.readText(charset: Charset = Charsets.UTF_8): String = readBytes().toString(charset)
//        Toast.makeText(this, file.readText(), Toast.LENGTH_SHORT).show()
//        textView=TextView(this)
        Dog().show(Dog())

        val string = categoryBean?.name ?: "empty"
    }

    /**
     * 静态添加，不具备运行时多态效果：com.syz.kotlinsimple E/syz: animal:animal
     */
    open class Animal

    class Dog : Animal()

    fun Animal.name() = "animal"
    fun Dog.name() = "dog"
    fun Animal.show(animal: Animal) {
        //com.syz.kotlinsimple E/syz: animal:animal--file:null--catsddd
        Log.e("syz", "animal:${animal.name()}--file:${textView?.showstr()}--cat${categoryBean?.cat}")
        Toast.makeText(applicationContext, "animal:${animal.name()}", Toast.LENGTH_SHORT).show()
    }

    fun TextView.showstr() = "showstr"


    //怎么扩展成员变量
    val CategoryBean.cat: String
        get() = "sddd"

}
