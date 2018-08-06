package com.syz.kotlinsimple.view.mineview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.graphics.RectF
import android.os.Build
import android.support.annotation.RequiresApi


/**
 * Created by shiyuzhe on 2018/8/5.
 * WeChat:18091664559
 * Description:
 */
class CustomView : View {

    val paint = Paint()

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
            context,
            attrs,
            defStyleAttr
    ) {
        init()
    }

    private fun init() {
        paint.isAntiAlias = true //抗锯齿
        paint.strokeWidth = 5f //画笔宽度
        paint.color = Color.RED //画笔颜色
        paint.style = Paint.Style.STROKE //画笔样式
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawRect(100f, 100f, 200f, 200f, paint)
        paint.style = Paint.Style.FILL
        canvas?.drawRect(Rect(300, 100, 400, 200), paint)
        paint.style = Paint.Style.FILL_AND_STROKE
        canvas?.drawRect(RectF(500f, 100f, 600f, 200f), paint)
        paint.style = Paint.Style.STROKE
        canvas?.drawCircle(200f, 400f, 50f, paint)
        //畫橢圓
        canvas?.drawOval(RectF(300f, 300f, 600f, 400f), paint)
        //話圓弧
        canvas?.drawArc(RectF(700f, 300f, 1000f, 400f), 0f, -270f, true, paint)
        //画圆角矩形
        canvas?.drawRoundRect(100f, 500f, 300f, 700f, 50f, 50f, paint)
        canvas?.drawRoundRect(RectF(400f, 500f, 600f, 700f), 50f, 50f, paint)

        //drawText:https://www.jianshu.com/p/c5764266aaac
        //贝塞尔曲线:https://www.jianshu.com/p/7e09d13cd9b4
        //Paint屬性：https://www.jianshu.com/p/54ccba13e14c

        //canvas.draw  :   新建一个透明图层，图层，透明图层覆盖在屏幕上显示
//        1、每次调用canvas.drawXXXX系列函数来绘图进，都会产生一个全新的Canvas画布。
//        2、如果在DrawXXX前，调用平移、旋转等函数来对Canvas进行了操作，那么这个操作是不可逆的！每次产生的画布的最新位置都是这些操作后的位置。（关于Save()、Restore()的画布可逆问题的后面再讲）
//        3、在Canvas与屏幕合成时，超出屏幕范围的图像是不会显示出来的

    }
}