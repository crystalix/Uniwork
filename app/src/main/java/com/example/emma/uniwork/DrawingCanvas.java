package com.example.emma.uniwork;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Build;

/**
 * Created by Emma on 02/08/2016.
 */

//this class doesn't seem to work


public class DrawingCanvas extends View
{
    private final int paintColour = Color.BLACK;
    private Paint drawPaint;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)


    public DrawingCanvas(Context context, AttributeSet attributes)
    {
        super(context, attributes);
        setFocusable(true);
        //the next line that's commented out doesn't work
        //SetFocusableInTouchMode(true);
    }

    //sets up the colour and type of line to be used
    private void setUpPaint()
    {
        drawPaint = new Paint();
        drawPaint.setColor(paintColour);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    //draws 3 circles on the canvas
    protected void onDraw(Canvas canvas)
    {
        canvas.drawCircle(50,50,20,drawPaint);
        drawPaint.setColor(Color.GREEN);
        canvas.drawCircle(50,150,20,drawPaint);
        drawPaint.setColor(Color.BLUE);
        canvas.drawCircle(50,250,20,drawPaint);
    }
}
