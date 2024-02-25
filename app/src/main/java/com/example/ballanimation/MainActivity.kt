package com.example.ballanimation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.graphics.Path
import android.graphics.PathMeasure
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.ballanimation.databinding.ActivityMainBinding

//class MainActivity : AppCompatActivity() {
//
//    private lateinit var mainBinding: ActivityMainBinding
//    private lateinit var ball: ImageView
//    private lateinit var pathView: PathView
//
//    @SuppressLint("ObjectAnimatorBinding")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        mainBinding = ActivityMainBinding.inflate(layoutInflater)
//        val view = mainBinding.root
//        setContentView(view)
//
//        ball = findViewById(mainBinding.ball.id)
//        pathView = findViewById(R.id.pathView)
//
//        // Create an ObjectAnimator for the X-axis (horizontal) movement
//        val bounceAnimator = ObjectAnimator.ofFloat(
//            ball,
//            "translationX",
//            0f, // Start position (left)
//            resources.displayMetrics.widthPixels - ball.width.toFloat() // End position (right)
//        )
//
//        // Create a custom path to follow
//        val path = Path()
//        path.moveTo(0f, 700f) // Start position
//        path.quadTo(
//            resources.displayMetrics.widthPixels / 1f, 10f, // Control point for the bounce
//            resources.displayMetrics.widthPixels.toFloat(), 100f // End position
//        )
//
//        // Create a PathMeasure for tracking the path
//        val pathMeasure = PathMeasure(path, false)
//        val tan = floatArrayOf(0f, 0f)
//        val pos = floatArrayOf(0f, 0f)
//
//        bounceAnimator.duration = 6000
//
//        // Create a ValueAnimator for the bounce height
//        val bounceHeightAnimator = ValueAnimator.ofFloat(0f, 1f)
//        bounceHeightAnimator.duration = 500 // Ball bounce speed
//        bounceHeightAnimator.repeatMode = ValueAnimator.REVERSE
//        bounceHeightAnimator.repeatCount = ValueAnimator.INFINITE
//
//        bounceHeightAnimator.addUpdateListener { animation ->
//            val value = animation.animatedValue as Float
//            pathMeasure.getPosTan(value * pathMeasure.length, pos, tan)
//            ball.translationY = pos[1] // Set the Y position using the path
//            pathView.updatePath(pos[0], pos[1]) // Update the path
//        }
//
//        // Create an AnimatorSet to combine the horizontal and vertical animations
//        val animatorSet = AnimatorSet()
//        animatorSet.playTogether(bounceAnimator, bounceHeightAnimator)
//
//        // Start the animation
//        animatorSet.start()
//    }
//}


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.ball)
        val pathView = findViewById<PathView>(R.id.pathView)

        // Create a path
        val path = Path()
        path.moveTo(10f, 100f)
        path.lineTo(700f, 100f)
//        path.lineTo(100f, 0f)
//        path.lineTo(300f, 300f)
//        path.lineTo(100f, 300f)
        path.close() // Close the path to create a loop
        pathView.setPath(path)

        // Create an ObjectAnimator for x and y properties
        val animator = ObjectAnimator.ofFloat(imageView, View.X, View.Y, path)
        animator.duration = 3000 // Animation duration in milliseconds

        // Start the animation
        animator.start()
    }
}


//class MainActivity : AppCompatActivity() {
//
////    @SuppressLint("MissingInflatedId")
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
//////        mainBinding = ActivityMainBinding.inflate(layoutInflater)
//////        val view = mainBinding.root
////        setContentView(R.layout.activity_main)
////
////        val bouncePath = Path()
////        bouncePath.moveTo(100f, 300f) // Start position
////        bouncePath.quadTo(
////            resources.displayMetrics.widthPixels / 2f, -300f, // Control point for the bounce
////            resources.displayMetrics.widthPixels.toFloat(), 300f // End position
////        )
////
////        val ball = findViewById<ImageView>(R.id.ball)
////        val bounceAnimator = ObjectAnimator.ofFloat(
////            ball,
////            View.X,
////            View.Y,
////            bouncePath
////        )
////        bounceAnimator.duration = 6000
////        bounceAnimator.start()
////
////        val pathView = findViewById<PathView>(R.id.pathView)
////        pathView.setPath(bouncePath)
//
//
//
//
////        val ball = findViewById<ImageView>(R.id.ball)
////
////        // Create a custom PathView
////        val pathView = findViewById<PathView>(R.id.pathView)
////
////        val path = Path()
////        path.moveTo(100f, 400f) // Start position
////        path.quadTo(
////            resources.displayMetrics.widthPixels / 2f, -300f, // Control point for the bounce
////            resources.displayMetrics.widthPixels.toFloat(), 400f // End position
////        )
////
////        pathView.setPath(path) // Set the path in the PathView
////
////        val bounceAnimator = ObjectAnimator.ofFloat(
////            ball,
////            "x",
////            "y",
////            path
////        )
////        bounceAnimator.duration = 6000
////
////        val bounceHeightAnimator = ValueAnimator.ofFloat(0f, 1f)
////        bounceHeightAnimator.duration = 500
////        bounceHeightAnimator.repeatMode = ValueAnimator.REVERSE
////        bounceHeightAnimator.repeatCount = ValueAnimator.INFINITE
////
////        bounceHeightAnimator.addUpdateListener { animation ->
////            val value = animation.animatedValue as Float
////            ball.translationY = value * -300
////        }
////
////        val animatorSet = AnimatorSet()
////        animatorSet.playTogether(bounceAnimator, bounceHeightAnimator)
////        animatorSet.start()
//
//
//
//
//
//
//
////        val path = Path() // Create a Path object for the ball's vertical movement
////        path.moveTo(0f, 0f) // Start position
////        path.quadTo(
////            resources.displayMetrics.widthPixels / 2f, -300f, // Control point for the bounce
////            resources.displayMetrics.widthPixels.toFloat(), 0f // End position
////        )
////
////        // Create an ObjectAnimator for the X-axis (horizontal) movement
////        val bounceAnimator = ObjectAnimator.ofFloat(
////            ball,
////            "translationX",
////            0f, // Start position (left)
////            resources.displayMetrics.widthPixels - ball.width.toFloat() // End position (right)
////        )
////
////
////        val pathMeasure = PathMeasure(path, false)
////        var distance = 0f
////        val tan = floatArrayOf(0f, 0f)
////        val pos = floatArrayOf(0f, 0f)
////
////        bounceAnimator.duration = 6000
////
////        // Create a ValueAnimator for the bounce height
////        val bounceHeightAnimator = ValueAnimator.ofFloat(0f, 1f)
////        bounceHeightAnimator.duration = 500 // Ball bounce speed
////        bounceHeightAnimator.repeatMode = ValueAnimator.REVERSE
////        bounceHeightAnimator.repeatCount = ValueAnimator.INFINITE
////
////        bounceHeightAnimator.addUpdateListener { animation ->
////            val value = animation.animatedValue as Float
////            pathMeasure.getPosTan(value * pathMeasure.length, pos, tan)
////            ball.translationY = pos[1] // Set the Y position using the path
//////            path.moveTo(0f,1f)
//////            path.addPath(path,0f,1f)
////            pathView.setPath(path)
////            pathView.invalidate() // Redraw the path
////        }
////
////        // Create an AnimatorSet to combine the horizontal and vertical animations
////        val animatorSet = AnimatorSet()
////        animatorSet.playTogether(bounceAnimator, bounceHeightAnimator)
////
////        // Start the animation
////        animatorSet.start()
//    }
//}
//
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        setContentView(R.layout.activity_main)
////
////        val bouncingBallView = findViewById<BouncingBallView>(R.id.bouncingBallView)
////        val pathView = findViewById<PathView>(R.id.pathView)
////
////        // Create a path for the ball to follow
////        val path = Path()
////        path.moveTo(50f, 400f)
////        path.quadTo(200f, 100f, 350f, 400f)
////
////        // Set the path for the PathView
////        pathView.setPath(path)
////
////        // Start the ball's bouncing animation
////        bouncingBallView.startBouncing()
////    }
//}

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val bouncingBallView = findViewById<BouncingBallView>(R.id.bouncingBallView)
//        val pathDrawingView = findViewById<PathDrawingView>(R.id.pathDrawingView)
//
//        // Start the ball's bounce animation
//        bouncingBallView.startBounceAnimation()
//
//        // Add an update listener to continuously update the path for the ball
//        bouncingBallView.setBounceUpdateListener { positionY ->
//            pathDrawingView.updatePathForBouncingBall(positionY)
//        }
//    }
//}

//class MainActivity : AppCompatActivity() {
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val ball = findViewById<ImageView>(R.id.ball)
//
//        val pathView = findViewById<PathView>(R.id.pathView)
//        val bouncingBallView = findViewById<BouncingBallView>(R.id.bouncingBallView)
//
//        // Create the path
//        val path = createPath()
//
//        // Set the path for the PathView
//        pathView.setPath(path)
//
//        // Create and start the path drawing animation
//        pathView.startDrawingAnimation(5000) // Set the duration of the path drawing animation
//
//        // Create an ObjectAnimator to move the ball along the path
//        val ballAnimator = ObjectAnimator.ofFloat(bouncingBallView, View.X, View.Y, path)
//        ballAnimator.duration = 5000 // Set the duration of the ball animation
//        ballAnimator.interpolator = AccelerateDecelerateInterpolator()
//
//        // Create and start a ball bouncing animation
//        val bounceAnimator = ValueAnimator.ofFloat(0f, 1f)
//        bounceAnimator.duration = 1000
//        bounceAnimator.interpolator = AccelerateDecelerateInterpolator()
//        bounceAnimator.repeatMode = ValueAnimator.REVERSE
//        bounceAnimator.repeatCount = ValueAnimator.INFINITE
//
//        bounceAnimator.addUpdateListener { animation ->
//            val fraction = animation.animatedValue as Float
//            val translationY = fraction * 100 // Adjust this value for the desired bounce height
//            bouncingBallView.translationY = translationY
//        }
//
//        ballAnimator.start()
//        bounceAnimator.start()
//
//        // Create an ObjectAnimator for the X-axis (horizontal) movement
//        val bounceAnimator1 = ObjectAnimator.ofFloat(
//            ball,
//            "translationX",
//            0f, // Start position (left)
//            resources.displayMetrics.widthPixels - ball.width.toFloat() // End position (right)
//        )
//
////    sets the duration of the animation to 2000 milliseconds (2 seconds)
//        bounceAnimator1.duration = 6000
//
//        // Create a ValueAnimator for the bounce height
//        val bounceHeightAnimator = ValueAnimator.ofFloat(0f, 350f)
//        bounceHeightAnimator.duration = 500 //ball bounce speed
//        bounceHeightAnimator.repeatMode = ValueAnimator.REVERSE
//        bounceHeightAnimator.repeatCount = ValueAnimator.INFINITE
//
//        bounceHeightAnimator.addUpdateListener { animation ->
//            val value = animation.animatedValue as Float
//            ball.translationY = value
//        }
//
//        // Create an AnimatorSet to combine the horizontal and vertical animations
//        val animatorSet = AnimatorSet()
//        animatorSet.playTogether(bounceAnimator1, bounceHeightAnimator)
//
//        // Start the animation
//        animatorSet.start()
//    }
//    }


//import android.annotation.SuppressLint
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.animation.AccelerateDecelerateInterpolator
//import android.view.animation.Animation
//import android.view.animation.AnimationSet
//import android.view.animation.TranslateAnimation
//import kotlin.math.sin
//
//class MainActivity : AppCompatActivity() {
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val bouncingBallView = findViewById<BouncingBallView>(R.id.bouncingBallView)
//
//        val startX = 100f
//        val startY = 100f
//        val endX = 300f
//        val endY = 300f
//
//        val translateAnimation = TranslateAnimation(startX, endX, startY, endY)
//        translateAnimation.duration = 3000 // Set the duration of the animation (in milliseconds)
//        translateAnimation.interpolator = AccelerateDecelerateInterpolator()
//
//        val animationSet = AnimationSet(true)
//        animationSet.addAnimation(translateAnimation)
//
//        bouncingBallView.startAnimation(animationSet)
//
//        val pathView = findViewById<PathView>(R.id.pathView)
//        pathView.pathPoints.clear()
////        val bouncingBallView = findViewById<BouncingBallView>(R.id.bouncingBallView)
//
////        bouncingBallView.setAnimationListener(object : Animation.AnimationListener {
////            override fun onAnimationStart(animation: Animation?) {
////                pathView.pathPoints.clear()
////            }
////
////            override fun onAnimationEnd(animation: Animation?) {
////                // Animation has ended
////            }
////
////            override fun onAnimationRepeat(animation: Animation?) {
////                // Animation has repeated
////            }
////        })
//
//    }
//}
//
//
////class MainActivity : AppCompatActivity() {
////    private lateinit var mainBinding: ActivityMainBinding
////    private lateinit var pathView: SurfaceView
////    private lateinit var ball: View
//////    private var currentPath: Path = Path()
////
////
////    @SuppressLint("ObjectAnimatorBinding")
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        mainBinding = ActivityMainBinding.inflate(layoutInflater)
////        val view = mainBinding.root
////        setContentView(view)
////
////        pathView = findViewById(R.id.path)
////        ball = findViewById(R.id.ball)
////
//////        // Set up the animation path
//////        val path = Path()
//////        path.moveTo(20f, 150f)  // Start position (left)
//////        path.lineTo(resources.displayMetrics.widthPixels - ball.width.toFloat(), 150f) // End position (right)
//////
//////        // Draw the animation path on the SurfaceView
//////        pathView.holder.addCallback(object : SurfaceHolder.Callback {
//////            override fun surfaceCreated(holder: SurfaceHolder) {
//////                val canvas = holder.lockCanvas()
//////                val paint = Paint()
//////                paint.color = Color.WHITE
//////                paint.strokeWidth = 8f
//////                paint.style = Paint.Style.STROKE
//////                canvas.drawPath(path, paint)
//////                holder.unlockCanvasAndPost(canvas)
//////            }
//////
//////            override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}
//////
//////            override fun surfaceDestroyed(holder: SurfaceHolder) {}
//////        })
//////
//////        // Create an ObjectAnimator for the X-axis (horizontal) movement
//////        val bounceAnimator = ObjectAnimator.ofFloat(
//////            ball,
//////            "x",
//////            path.getPoint(0f).x,
//////            path.getPoint(1f).x
//////        )
//////
//////        bounceAnimator.duration = 2000
//////        bounceAnimator.interpolator = BounceInterpolator()
//////        bounceAnimator.repeatMode = ValueAnimator.REVERSE
//////        bounceAnimator.repeatCount = ValueAnimator.INFINITE
//////
//////        bounceAnimator.addUpdateListener {
//////            // Update the path with the ball's current position
//////            currentPath.reset()
//////            currentPath.addPath(path)
//////            currentPath.addCircle(ball.x + ball.width / 2, ball.y + ball.height / 2, 10f, Path.Direction.CCW)
//////
//////            // Redraw the animation path with the ball's current position
//////            pathView.holder.lockCanvas()?.let { canvas ->
//////                val paint = Paint()
//////                paint.color = Color.WHITE
//////                paint.strokeWidth = 8f
//////                paint.style = Paint.Style.STROKE
//////                canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
//////                canvas.drawPath(currentPath, paint)
//////                pathView.holder.unlockCanvasAndPost(canvas)
//////            }
//////        }
//////
//////        bounceAnimator.start()
//////    }
//////}
////
////// Create an ObjectAnimator for the X-axis (horizontal) movement
////        val bounceAnimator = ObjectAnimator.ofFloat(
////            ball,
////            "translationX",
////            0f, // Start position (left)
////            resources.displayMetrics.widthPixels - ball.width.toFloat() // End position (right)
////        )
////
//////    sets the duration of the animation to 2000 milliseconds (2 seconds)
////        bounceAnimator.duration = 6000
////
////        // Create a ValueAnimator for the bounce height
////        val bounceHeightAnimator = ValueAnimator.ofFloat(0f, 350f)
////        bounceHeightAnimator.duration = 500 //ball bounce speed
////        bounceHeightAnimator.repeatMode = ValueAnimator.REVERSE
////        bounceHeightAnimator.repeatCount = ValueAnimator.INFINITE
////
////        bounceHeightAnimator.addUpdateListener { animation ->
////            val value = animation.animatedValue as Float
////            ball.translationY = value
////        }
////
////        // Create an AnimatorSet to combine the horizontal and vertical animations
////        val animatorSet = AnimatorSet()
////        animatorSet.playTogether(bounceAnimator, bounceHeightAnimator)
////
////        // Start the animation
////        animatorSet.start()
////    }
////}
//
