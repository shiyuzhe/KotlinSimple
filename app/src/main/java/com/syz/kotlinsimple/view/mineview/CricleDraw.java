package com.syz.kotlinsimple.view.mineview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:shiyuzhe on 2018/7/16 14:55
 * 邮箱:18091664559@163.com
 * Desc:
 */
public class CricleDraw extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int color = Color.RED;

    public CricleDraw(Context context) {
        super(context);
        init();
    }

    public CricleDraw(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CricleDraw(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint.setColor(color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int min = Math.min(width, height) / 2;
        canvas.drawCircle(width/2, height/2, min, paint);
    }
}
