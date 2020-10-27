package com.martiandeveloper.a1delay_execution_of_a_runnable_object

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runCode()
    }

    private fun runCode() {

        Handler(Looper.getMainLooper()).postDelayed({
            Log.i(
                    "MainActivity",
                    "Operation from Runnable"
            )
        }, 4000)


        Handler(Looper.getMainLooper()).postAtTime({
            Log.i(
                    "MainActivity",
                    "Posting at a certain time"
            )
        }, SystemClock.uptimeMillis() + 8000)

    }

}
