package com.husseinelfeky.session6.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.husseinelfeky.session6.databinding.ActivityRouteViewBinding

class RouteViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRouteViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRouteViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    companion object {
        private val TAG = RouteViewActivity::class.simpleName
    }
}
