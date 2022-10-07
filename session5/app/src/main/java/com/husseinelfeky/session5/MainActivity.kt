package com.husseinelfeky.session5

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.husseinelfeky.session5.databinding.ActivityMainBinding
import com.husseinelfeky.session5.utils.NotificationUtils

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initApp()
        initClickListeners()
    }

    private fun initApp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationUtils.createNotificationChannel(
                this,
                NotificationUtils.getNewsChannel(this)
            )
        }
    }

    private fun initClickListeners() {
        binding.apply {
            btnDialogDefault.setOnClickListener {
                AlertDialog.Builder(this@MainActivity)
                    .setTitle(R.string.lorem_ipsum_title)
                    .setMessage(R.string.lorem_ipsum)
                    .setPositiveButton(R.string.btn_positive) { _, _ ->
                        Snackbar.make(
                            root,
                            R.string.message_positive_clicked,
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                    .setNegativeButton(R.string.btn_negative) { _, _ ->
                        Snackbar.make(
                            root,
                            R.string.message_negative_clicked,
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                    .setNeutralButton(R.string.btn_neutral) { _, _ ->
                        Snackbar.make(
                            root,
                            R.string.message_neutral_clicked,
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                    .show()
            }

            btnDialogMaterial.setOnClickListener {
                MaterialAlertDialogBuilder(this@MainActivity)
                    .setTitle(R.string.lorem_ipsum_title)
                    .setMessage(R.string.lorem_ipsum)
                    .setPositiveButton(R.string.btn_positive) { _, _ ->
                        Snackbar.make(
                            root,
                            R.string.message_positive_clicked,
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                    .setNegativeButton(R.string.btn_negative) { _, _ ->
                        Snackbar.make(
                            root,
                            R.string.message_negative_clicked,
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                    .setNeutralButton(R.string.btn_neutral) { _, _ ->
                        Snackbar.make(
                            root,
                            R.string.message_neutral_clicked,
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                    .show()
            }

            btnNotification.setOnClickListener {
                NotificationUtils.sendNotification(
                    context = this@MainActivity,
                    titleResId = R.string.notification_title,
                    messageResId = R.string.notification_message,
                    notificationId = NOTIFICATION_ID
                )
            }
        }
    }

    companion object {
        private const val NOTIFICATION_ID = 1000
    }
}
