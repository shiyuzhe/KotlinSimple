package com.syz.kotlinsimple

import android.app.Application
import android.content.Context
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import kotlin.properties.Delegates

/**

 * 作者:shiyuzhe on 2018/7/13 15:41
 * 邮箱:18091664559@163.com
 * Desc:
 */
class MyApplication : Application() {

    companion object {

        private val TAG = "MyApplication"

        var context: Context by Delegates.notNull()
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        initConfig()
    }

    /**
     * 初始化Logger
     */
    private fun initConfig() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)  // 隐藏线程信息 默认：显示
            .methodCount(0)         // 决定打印多少行（每一行代表一个方法）默认：2
            .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
            .tag("syz")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
            .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }
}