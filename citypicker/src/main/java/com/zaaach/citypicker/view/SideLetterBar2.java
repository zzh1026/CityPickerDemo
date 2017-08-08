package com.zaaach.citypicker.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.zaaach.citypicker.R;

/**
 * 这个类的作用是:
 * <p>
 * Created by zhaozh on 2017/6/1.
 */

public class SideLetterBar2 extends View {
    private String[] b = {"A", "B", "C", "D", "E", "F", "G", "H", "I",};    //所有的字母表
    private int choose = -1;
    private TextPaint mPaint;

    public SideLetterBar2(Context context) {
        this(context, null);
    }

    public SideLetterBar2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SideLetterBar2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(getResources().getDimension(R.dimen.side_letter_bar_letter_size));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int height = getHeight();
        int width = getWidth();

        int singleHeight = height / b.length;
        for (int i = 0; i < b.length; i++) {
            if (choose == i) {
                mPaint.setColor(getResources().getColor(R.color.gray_deep));
                mPaint.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                mPaint.setColor(getResources().getColor(R.color.gray));
                mPaint.setTypeface(Typeface.DEFAULT);
            }

            float xPos = width / 2 - mPaint.measureText(b[i]) / 2;
            float yPos = singleHeight * i + singleHeight;
            canvas.drawText(b[i], xPos, yPos, mPaint);
        }
    }
}
