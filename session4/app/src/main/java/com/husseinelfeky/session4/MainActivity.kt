package com.husseinelfeky.session4

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.husseinelfeky.session4.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val coroutineScope =
        CoroutineScope(SupervisorJob() + CoroutineName("MainActivityScope"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickListeners()
    }

    private fun initClickListeners() {
        binding.btnCalculate.setOnClickListener {
            val enteredNumber = binding.etNumber.text.toString()
            if (enteredNumber.isNotEmpty()) {
                showFactorial(enteredNumber.toInt())
            } else {
                Toast.makeText(this, "Please enter a number first.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showFactorial(number: Int) {
        coroutineScope.launch(Dispatchers.Default) {
            // Run on default thread.
            println("Coroutine ${coroutineContext[CoroutineName.Key]} is running on thread ${Thread.currentThread().name}.")
            val result = findFactorial(number)

            // TODO: Try replacing [Dispatchers.Main] with any other dispatcher, and enter 25 as the
            //  input.
            withContext(Dispatchers.Main) {
                // Run on main thread.
                println("Coroutine ${coroutineContext[CoroutineName.Key]} is running on thread ${Thread.currentThread().name}.")
                binding.tvResult.text = "$number! = $result"
            }
        }
    }

    private fun findFactorial(number: Int): Long {
        return if (number == 0) {
            1
        } else {
            number * findFactorial(number - 1)
        }
    }
}
