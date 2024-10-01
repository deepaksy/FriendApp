package com.example.friendapp

import android.app.Application
import android.util.Log
import com.example.friendapp.helpers.NotificationHelper
import com.example.friendapp.utils.getAllComments

class FriendApp: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        Log.i(LOG_NAME,"App created!")
        try {
            getAllComments()
        }
        catch (e: Exception) {
            Log.e(LOG_NAME, "$e")
        }
        NotificationHelper.createNotification()

        /***
         * Initialize the notification helper
         */

    }

    companion object {
        private const val LOG_NAME: String = "FriendApp"
        lateinit var instance: FriendApp
        const val DOWNLOAD_CHANNEL: String = "com.android.app"
    }
}