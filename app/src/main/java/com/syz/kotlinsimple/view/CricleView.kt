package com.syz.kotlinsimple.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View

/**
 * 作者:shiyuzhe on 2018/7/16 14:31
 * 邮箱:18091664559@163.com
 * Desc:
 */
class CricleView : View {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val color: Int = Color.GRAY

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
        paint.color = color
    }

    /*
    固定大小400？
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val modeWidth = MeasureSpec.getMode(widthMeasureSpec)
        val modeHeight = MeasureSpec.getMode(heightMeasureSpec)
        //AT_MOST对应wrap_content；EXACTLY对应match_parent
        if (modeWidth == MeasureSpec.AT_MOST && modeHeight == MeasureSpec.AT_MOST)
            setMeasuredDimension(400, 400)
        else if (modeWidth == MeasureSpec.AT_MOST)
            setMeasuredDimension(400, MeasureSpec.getSize(heightMeasureSpec))
        else if (modeHeight == MeasureSpec.AT_MOST)
            setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), 400)
    }

    /*
    margin由父布局控制，不用处理
    对于直接继承View的控件，如果不对wrap_content做特殊处理，那么使用wrap_content相当于使用match_parent
     */
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val meaWidth = width.toFloat() - paddingLeft - paddingRight
        val meaHeight = height.toFloat() - paddingTop - paddingBottom
        val radius = Math.min(meaWidth, meaHeight) / 2
        canvas.drawCircle(
            meaWidth / 2 + paddingLeft,
            meaHeight / 2 + paddingTop,
            radius,
            paint
        )

    }
}
