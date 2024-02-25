package com.example.ballanimation

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class PathView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val path = Path()
    private val paint = Paint()
    private var lastX: Float = 0f
    private var lastY: Float = 0f

    init {
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5f
        path.moveTo(0f, 0f)
        path.quadTo(context.resources.displayMetrics.widthPixels / 2f, -500f, context.resources.displayMetrics.widthPixels.toFloat(), 0f)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//        canvas.drawPath(path, paint)
        super.onDraw(canvas)
        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5f
        canvas.drawPath(path, paint)
    }

    fun setPath(newPath: Path) {
        path.reset()
        path.addPath(newPath)
        invalidate()
    }
    fun updatePath(newX: Float, newY: Float) {
        path.quadTo(
            (lastX + newX) / 2, (lastY + newY) / 2, // Control point for the bounce
            newX, newY // End position
        )
        lastX = newX
        lastY = newY
        invalidate()
    }
}

//class PathView(context: Context, attrs: AttributeSet) : View(context, attrs) {
//    private val path = Path()
//    private val paint = Paint()
//
//    init {
//        paint.color = Color.RED
//        paint.style = Paint.Style.STROKE
//        paint.strokeWidth = 5f
//        path.moveTo(0f, 0f)
//        path.quadTo(context.resources.displayMetrics.widthPixels / 2f, -300f, context.resources.displayMetrics.widthPixels.toFloat(), 0f)
//    }
//
//    @SuppressLint("DrawAllocation")
//    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//        val paint = Paint()
//        paint.color = Color.RED
//        paint.style = Paint.Style.STROKE
//        paint.strokeWidth = 5f
//        canvas.drawPath(path, paint)
//    }
//}


//import android.content.Context
//import android.graphics.Canvas
//import android.graphics.Color
//import android.graphics.Paint
//import android.graphics.Path
//import android.util.AttributeSet
//import android.view.View
//
//class PathView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
//    private val pathPaint = Paint().apply {
//        color = Color.RED
//        style = Paint.Style.STROKE
//    }
//
//    private val path = Path()
//
//    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//        canvas.drawPath(path, pathPaint)
//    }
//
//    fun setPath(path: Path) {
//        this.path.reset()
//        this.path.set(path)
//    }
//
//    fun startDrawingAnimation(duration: Long) {
//        val animation = PathDrawingAnimation(this, path)
//        animation.duration = duration
//        startAnimation(animation)
//    }
//}
