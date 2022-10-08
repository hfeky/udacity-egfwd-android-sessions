package com.husseinelfeky.session6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.husseinelfeky.session6.activities.DialViewActivity
import com.husseinelfeky.session6.activities.RouteViewActivity
import com.husseinelfeky.session6.activities.ValueAnimatorActivity
import com.husseinelfeky.session6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickListeners()
    }

    private fun initClickListeners() {
        binding.apply {
            btnRouteView.setOnClickListener {
                startActivity(Intent(this@MainActivity, RouteViewActivity::class.java))
            }

            btnDialView.setOnClickListener {
                startActivity(Intent(this@MainActivity, DialViewActivity::class.java))
            }

            btnValueAnimator.setOnClickListener {
                startActivity(Intent(this@MainActivity, ValueAnimatorActivity::class.java))
            }
        }
    }
}
