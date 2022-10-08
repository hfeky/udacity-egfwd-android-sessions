package com.husseinelfeky.session6.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.husseinelfeky.session6.databinding.ActivityDialViewBinding

class DialViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDialViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDialViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
