package com.syz.kotlinsimple.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.mvp.model.bean.CategoryBean
import java.io.File

/**
 * kotlin 的构造函数：创建对象的关键
 * 构造函数
 * 访问修饰符
 * 伴生对象
 * 单例类
 * 动态代理
 * Kotlin特有类
 */
class ActSimple9 : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_simple3)
        StringUtils.isEmpty("")
        Single.get()
        Zoo(Dog()).bark()
    }

    /**
     * 9构造函数
     * class ActSimple9 : AppCompatActivity()
     * class ActSimple9 : AppCompatActivity(),View.OnClickListener
     * Kotlin的类默认是public final的，不需要final就手动添加open
     * open class ActSimple9 : AppCompatActivity()
     * open class ActSimple9 : AppCompatActivity(),View.OnClickListener
     *      访问修饰符
     * private  protected    public
     * internal:一个模块中的类可以访问这个对象（模块:Module）
     */

    /**
     * 10伴生对象
     * 静态方法
     * Kotlin没有静态方法，可以用伴生对象实现
     * companion object
     */
    class StringUtils {
        companion object {
            fun isEmpty(string: String): Boolean {
                return "" == string
            }
        }
    }

    /**
     * 10伴生对象
     * 单例
     * 使用伴生对象来声明单例
     */

    class Single private constructor() {
        companion object {
            fun get(): Single {
                return Holder.instance
            }
        }

        private object Holder {
            val instance = Single()
        }
    }

    /**
     * 11动态代理
     * Kotlin的动态代理会在编译后转化成静态代理去调用，比java动态代理（反射）效率高
     */
    interface Animal {
        fun bark()
    }

    class Dog : Animal {
        override fun bark() {
            Log.e("syz", "wang")
        }
    }

    class Zoo(animal: Animal) : Animal by animal
//    class Zoo(animal: Animal):Animal by animal{
    //如果重写.不会调用代理对象的bark方法
//        override fun bark() {
//        }
//    }

    /**
     * 数据类
     * 编译器会重写get/set,toString,hasCode,equals,copy
     * 声明：类声明之前加上data
     * final类型，不能添加open修饰它，不能被继承
     */

    /**
     * 枚举类
     * Kotlin中使用密闭类，可以扩展子类
     */
}
