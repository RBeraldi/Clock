package com.beraldi.clock


import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.withMatrix
import kotlin.math.cos
import kotlin.math.sin

class MyView : View {


    val mPaint = Paint().apply {
        style=Paint.Style.STROKE
        color = Color.RED
        strokeWidth=5f
        isAntiAlias = true
        textSize=50f

    }



    constructor(context: Context) : super(context,null)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)


        val cx = canvas.width/2f
        val cy = canvas.height/2f

        var tt = System.currentTimeMillis()
        val radius =200f


        var sec = tt.toDouble()/1000.0 //Seconds
        sec%=60 //from [0 60)
        var a = sec/60.0 // convert to [0..1)
        val angleSec = 2*Math.PI*a-Math.PI/2 //45 degree rotation to align 0 to vertical


        var x = 0.9*radius * Math.cos(angleSec) + cx
        var y = - 0.9*radius * Math.sin(-angleSec) + cy

        canvas.drawLine(cx,cy,x.toFloat(),y.toFloat(),mPaint)

        canvas.drawCircle(cx,cy,radius,mPaint)

        for (i in 0 until 12){
            val x1 = 1.1*radius*Math.cos(i*2.0*Math.PI/12)+cx
            val y1 = -1.1*radius*Math.sin(i*2.0*Math.PI/12)+cy

            val x2 = 0.9*radius*Math.cos(i*2.0*Math.PI/12)+cx
            val y2 = -0.9*radius*Math.sin(i*2.0*Math.PI/12)+cy
            canvas.drawLine(x1.toFloat(),y1.toFloat(),x2.toFloat(),y2.toFloat(),mPaint)
        }
        invalidate()


        return

    }

}