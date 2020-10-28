package com.martiandeveloper.a2manage_background_tasks_with_threads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runCode()
    }

    private fun runCode() {

        // We're running in a background thread.
        // When you're in a background thread,
        // you do not have direct access to the UI.

        /*val runnable = Runnable {

            for (i in 1..10) {
                Log.i(TAG, "Looping $i")
                Thread.sleep(1000)
            }

            Log.i(TAG, "All done!")

        }

        val thread = Thread(runnable)
        thread.start()*/


        //todo Let's shrink this code down

        /*Thread {

            for (i in 1..10) {
                Log.i(TAG, "Looping $i")
                Thread.sleep(1000)
            }

            Log.i(TAG, "All done!")

        }.start()*/


        //todo Let's use an extension function from the Kotlin concurrency package

        thread(start = true) {

            for (i in 1..10) {
                Log.i(TAG, "Looping $i")
                Thread.sleep(1000)
            }

            Log.i(TAG, "All done!")

        }

    }

}
