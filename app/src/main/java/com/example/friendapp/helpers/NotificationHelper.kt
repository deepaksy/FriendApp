package com.example.friendapp.helpers

import android.content.Context
import android.util.Log
import androidx.work.ExistingPeriodicWorkPolicy


object NotificationHelper {
    private const val NOTIFICATION_WORK_NAME: String = "NotificationService"

    fun createNotification() {
        val notificationCounter: Int
        for (i in 1..10) {
            Log.i("LOOP", "$i")
        }
    }
}