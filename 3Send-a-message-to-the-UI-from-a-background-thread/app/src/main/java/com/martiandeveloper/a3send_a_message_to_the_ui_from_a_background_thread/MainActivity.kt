package com.martiandeveloper.a3send_a_message_to_the_ui_from_a_background_thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.TextView
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private val handler = object : Handler(Looper.getMainLooper()) {

        override fun handleMessage(msg: Message) {
            findViewById<TextView>(R.id.activity_main_mainTV).text = msg.data.getString(MESSAGE_KEY)
                    ?: "Message was null"
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runCode()
    }

    private fun runCode() {

        thread(start = true) {

            for (i in 1..10) {
                // Each message can only be used once
                val bundle = Bundle()
                bundle.putString(MESSAGE_KEY, "Looping $i")

                Message().also {
                    it.data = bundle
                    handler.sendMessage(it)
                }

                Thread.sleep(1000)
            }

            Log.i(TAG, "All done!")

        }

    }

}
