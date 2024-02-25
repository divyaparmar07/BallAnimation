package com.example.ballanimation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import android.animation.ValueAnimator
import android.graphics.Color
class PathDrawingView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val pathPaint = Paint().apply {
        color = Color.RED
        style = Paint.Style.STROKE
    }

    // Define the path to be drawn
    private val path = Path()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // Draw the path on the canvas
        canvas.drawPath(path, pathPaint)
    }

    fun updatePathForBouncingBall(positionY: Float) {
        // Update the path based on the current position of the bouncing ball
        // This can be done by adding line or curve segments to the path
        // Use this method to continuously update the path based on the ball's position
        path.reset()
//        path.moveTo(startX, startY)
//        path.lineTo(currentX, positionY)
        // Add more segments as needed
        // Invalidate the view to trigger a redraw
        invalidate()
    }
}

//class PathDrawingView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
//    private val pathPaint = Paint()
//    private val path = Path()
//    private var pathLength = 0f
//
//    init {
//        pathPaint.color = Color.RED
//        pathPaint.style = Paint.Style.STROKE
//        pathPaint.strokeWidth = 5f
//
//        // Define your desired path
//        path.moveTo(100f, 100f)
//        path.lineTo(300f, 100f)
//        path.lineTo(300f, 300f)
//        path.lineTo(100f, 300f)
//        path.close()
//        pathLength = pathMeasure.length
//
//        // Animate the path drawing
//        val pathAnimator = ValueAnimator.ofFloat(0f, 1f)
//        pathAnimator.duration = 3000
//        pathAnimator.addUpdateListener { animation ->
//            val animatedValue = animation.animatedValue as Float
//            val phase = animatedValue * pathLength
//            path.reset()
//            pathMeasure.getSegment(0f, phase, path, true)
//            invalidate()
//        }
//        pathAnimator.start()
//    }
//
//    private val pathMeasure = android.graphics.PathMeasure(path, false)
//
//    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//        canvas.drawPath(path, pathPaint)
//    }
//}
