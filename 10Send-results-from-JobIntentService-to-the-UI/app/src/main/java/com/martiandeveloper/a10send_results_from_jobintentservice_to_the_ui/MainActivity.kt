package com.martiandeveloper.a10send_results_from_jobintentservice_to_the_ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.ResultReceiver
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val receiver = MyResultReceiver(Handler(Looper.getMainLooper()))

        MyIntentService.startAction(this, FILE_URL, receiver)
    }

    private inner class MyResultReceiver(handler: Handler) : ResultReceiver(handler) {

        override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {

            if (resultCode == Activity.RESULT_OK) {
                val contents = resultData?.getString(FILE_CONTENTS_KEY) ?: "Null"
                findViewById<TextView>(R.id.activity_main_mainTV).text = contents
            }

        }

    }

}
