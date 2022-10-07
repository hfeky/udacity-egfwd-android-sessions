package com.husseinelfeky.session5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.husseinelfeky.session5.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotificationBinding

    private var notificationTitle: String? = null
    private var notificationMessage: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadExtras()
        initClickListeners()
        displayNotificationData()
    }

    private fun loadExtras() {
        val extras = intent.extras
        extras?.let {
            notificationTitle = it.getString(EXTRA_TITLE)
            notificationMessage = it.getString(EXTRA_MESSAGE)
        }
    }

    private fun initClickListeners() {
        binding.apply {
            btnClose.setOnClickListener {
                finish()
            }
        }
    }

    private fun displayNotificationData() {
        binding.apply {
            tvTitle.text = notificationTitle
            tvMessage.text = notificationMessage
        }
    }

    companion object {
        private const val EXTRA_TITLE = "notification_title"
        private const val EXTRA_MESSAGE = "notification_message"

        fun withExtras(title: String, message: String): Bundle {
            return Bundle().apply {
                putString(EXTRA_TITLE, title)
                putString(EXTRA_MESSAGE, message)
            }
        }
    }
}
