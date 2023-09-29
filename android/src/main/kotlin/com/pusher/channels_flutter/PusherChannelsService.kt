package com.pusher.channels_flutter

import android.app.Activity
import android.os.IBinder
import android.content.Intent
import android.app.Service

import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding

class PusherChannelsService : Service() {

    private val pusherChannelsFlutterPlugin = PusherChannelsFlutterPlugin()
    private var activity: Activity? = null

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()

        pusherChannelsFlutterPlugin.onAttachedToEngine(null)
    }

    override fun onDestroy() {
        super.onDestroy()

        pusherChannelsFlutterPlugin.onDetachedFromEngine()
    }

    override fun onAttachedToActivity(binding: ActivityPluginBinding) {
        super.onAttachedToActivity(binding)

        activity = binding.activity
    }

    override fun onDetachedFromActivity() {
        super.onDetachedFromActivity()

        activity = null
    }

    fun getActivity(): Activity? {
        return activity
    }
}