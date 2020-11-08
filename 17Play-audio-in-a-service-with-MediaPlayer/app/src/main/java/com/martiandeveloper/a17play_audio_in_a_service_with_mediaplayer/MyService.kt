package com.martiandeveloper.a17play_audio_in_a_service_with_mediaplayer

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder

class MyService : Service() {

    private val binder = MyServiceBinder()

    private lateinit var player: MediaPlayer

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    fun startMusic() {

        try {
            player.stop()
            player.release()
        } catch (e: UninitializedPropertyAccessException) {
        }

        player = MediaPlayer().also {

            assets.openFd(AUDIO_FILE).use { asset ->
                it.setDataSource(asset.fileDescriptor, asset.startOffset, asset.length)
            }

            it.prepare()
            it.start()

        }

    }

    inner class MyServiceBinder : Binder() {
        fun getService() = this@MyService
    }

    fun stopMusic() {

        try {
            player.stop()
        } catch (e: UninitializedPropertyAccessException) {
        }

    }

}
