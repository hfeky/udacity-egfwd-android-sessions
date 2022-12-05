package com.husseinelfeky.session1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.husseinelfeky.session1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAndroid.setOnClickListener {
            Toast.makeText(this@MainActivity, "Hello Android!", Toast.LENGTH_SHORT).show()
        }

        binding.btnIos.setOnClickListener {
            Toast.makeText(this@MainActivity, "Hello iOS!", Toast.LENGTH_SHORT).show()
        }

        binding.btnWorld.setOnClickListener {
            Toast.makeText(this@MainActivity, "Hello World!", Toast.LENGTH_SHORT).show()
        }
    }
}
