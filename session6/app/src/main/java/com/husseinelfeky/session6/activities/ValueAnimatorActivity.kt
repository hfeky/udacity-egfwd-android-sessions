package com.husseinelfeky.session6.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.husseinelfeky.session6.databinding.ActivityValueAnimatorBinding

class ValueAnimatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityValueAnimatorBinding

    private lateinit var valueAnimator: ValueAnimator

    private var progressValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValueAnimatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initValueAnimator()
        initClickListeners()
    }

    @SuppressLint("SetTextI18n")
    private fun initClickListeners() {
        binding.apply {
            btnStart.setOnClickListener {
                valueAnimator.start()
                binding.tvLastAction.text = "Last Action\nStarted"
            }

            btnPause.setOnClickListener {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    valueAnimator.pause()
                    binding.tvLastAction.text = "Last Action\nPaused"
                } else {
                    Toast.makeText(
                        this@ValueAnimatorActivity,
                        "Pause not supported",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            btnResume.setOnClickListener {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    valueAnimator.resume()
                    binding.tvLastAction.text = "Last Action\nResumed"
                } else {
                    Toast.makeText(
                        this@ValueAnimatorActivity,
                        "Resume not supported",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            btnCancel.setOnClickListener {
                valueAnimator.cancel()
                binding.tvLastAction.text = "Last Action\nCanceled"
            }
        }
    }

    private fun initValueAnimator() {
        valueAnimator = ValueAnimator.ofInt(0, 360).setDuration(4000).apply {
            addUpdateListener {
                progressValue = it.animatedValue as Int
                updateTextViewText()
            }

            addListener(object : AnimatorListenerAdapter() {

                override fun onAnimationStart(animation: Animator) {
                    Log.d(TAG, "onAnimationStart")
                }

                override fun onAnimationEnd(animation: Animator) {
                    Log.d(TAG, "onAnimationEnd")
                }

                override fun onAnimationPause(animation: Animator) {
                    Log.d(TAG, "onAnimationPause")
                }

                override fun onAnimationResume(animation: Animator) {
                    Log.d(TAG, "onAnimationResume")
                }

                override fun onAnimationCancel(animation: Animator) {
                    Log.d(TAG, "onAnimationCancel")
                }

                override fun onAnimationRepeat(animation: Animator) {
                    Log.d(TAG, "onAnimationRepeat")
                }
            })

            interpolator = LinearInterpolator()
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
        }
    }

    private fun updateTextViewText() {
        binding.tvProgress.text = progressValue.toString()
    }

    companion object {
        private val TAG = ValueAnimatorActivity::class.simpleName
    }
}
