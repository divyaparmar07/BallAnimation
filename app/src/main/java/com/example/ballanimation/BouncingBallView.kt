package com.example.ballanimation

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View

class BouncingBallView(context: Context) : View(context) {
    private val ballRadius = 25f
    private val ballPaint = Paint().apply {
        color = 0xFF3498DB.toInt()
        style = Paint.Style.FILL
    }

    private var ballY = 0f

    private val bounceAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
        duration = 4000
        repeatCount = ValueAnimator.INFINITE
        repeatMode = ValueAnimator.REVERSE
        addUpdateListener {
            ballY = height - ballRadius - it.animatedValue as Float * (height - 2 * ballRadius)
            invalidate()
        }
    }

    fun startBouncing() {
        bounceAnimator.start()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(width / 2f, ballY, ballRadius, ballPaint)
    }
}

//import android.content.Context
//import android.graphics.Canvas
//import android.graphics.Color
//import android.graphics.Paint
//import android.util.AttributeSet
//import android.view.View
//import android.animation.ValueAnimator
//import android.view.animation.LinearInterpolator
//
//class BouncingBallView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
//    // Define properties for the ball
//    private val ballRadius = 25f
//    private val ballPaint = Paint().apply {
//        color = Color.BLUE
//        style = Paint.Style.FILL
//    }
//
//    // Define the bounce animation
//    private val bounceAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
//        duration = 1000
//        interpolator = LinearInterpolator()
//        repeatCount = ValueAnimator.INFINITE
//        repeatMode = ValueAnimator.REVERSE
//    }
//
//    init {
//        bounceAnimator.addUpdateListener { animation ->
//            // Update the position of the ball based on the animation value
//            val animatedValue = animation.animatedValue as Float
//            // Calculate the vertical position based on the animated value
//            // Use this position to draw the ball
//            val positionY = animatedValue * (height - 2 * ballRadius)
//            // Invalidate the view to trigger a redraw
//            invalidate()
//        }
//    }
//
//    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//        // Draw the ball at the calculated position
//        canvas.drawCircle(width / 2f, positionY, ballRadius, ballPaint)
//    }
//}

//class BouncingBallView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
//    private val ballRadius = 25f
//    private val ballPaint = Paint().apply {
//        color = Color.BLUE
//        style = Paint.Style.FILL
//    }
//
//    private var ballY = 0f
//
//    init {
//        val bounceAnimator = ValueAnimator.ofFloat(0f, 1f)
//        bounceAnimator.duration = 1000
//        bounceAnimator.addUpdateListener { animation ->
//            val fraction = animation.animatedValue as Float
//            ballY = fraction * 200 // Adjust this value for the desired bounce height
//            invalidate()
//        }
//        bounceAnimator.repeatCount = ValueAnimator.INFINITE
//        bounceAnimator.repeatMode = ValueAnimator.REVERSE
//        bounceAnimator.start()
//    }
//
//    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//        canvas.drawCircle(width / 2f, ballY, ballRadius, ballPaint)
//    }
//}
