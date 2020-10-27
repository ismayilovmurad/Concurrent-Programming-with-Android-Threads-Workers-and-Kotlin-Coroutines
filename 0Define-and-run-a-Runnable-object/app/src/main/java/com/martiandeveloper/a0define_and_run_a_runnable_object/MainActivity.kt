package com.martiandeveloper.a0define_and_run_a_runnable_object

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runCode()
    }

    private fun runCode() {

        //todo It will only be executed once everything else is complete.

        /*val runnable = object : Runnable {

            override fun run() {
                Log.i("MainActivity", "Operation from Runnable")
            }

        }

        val handler = Handler(Looper.getMainLooper())
        handler.post(runnable)*/


        //todo Let's convert to lambda
        /*val runnable = Runnable { Log.i("MainActivity", "Operation from Runnable") }

        val handler = Handler(Looper.getMainLooper())
        handler.post(runnable)*/


        //todo Let's reduce the code even more
        Handler(Looper.getMainLooper()).post { Log.i("MainActivity", "Operation from Runnable") }

    }

}
