package com.example.friendapp

import android.app.Application
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
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
        try {
            setShortcuts()
        }
        catch (e:Exception) {
            Log.i("MAIN_ERROR",e.toString())
        }
        /***
         * Initialize the notification helper
         */

    }

    private fun setShortcuts() {
        val shortcutManager = getSystemService(ShortcutManager::class.java)
        val shortcut = ShortcutInfo.Builder(this, "second_activity")
            .setShortLabel("Second")
            .setLongLabel("Second Activity")
            .setIcon(Icon.createWithResource(this, R.drawable.ic_launcher_foreground))
            .setIntent(Intent(this, MainActivity2::class.java).apply {
                action = Intent.ACTION_MAIN
            })
            .build()
    }

    companion object {
        private const val LOG_NAME: String = "FriendApp"
        lateinit var instance: FriendApp
        const val DOWNLOAD_CHANNEL: String = "com.android.app"
    }
}