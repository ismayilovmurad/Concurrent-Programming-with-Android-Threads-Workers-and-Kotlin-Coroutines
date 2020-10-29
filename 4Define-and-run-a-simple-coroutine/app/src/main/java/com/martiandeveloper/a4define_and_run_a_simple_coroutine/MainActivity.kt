package com.martiandeveloper.a4define_and_run_a_simple_coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runCode()
    }

    private fun runCode() {

        CoroutineScope((Dispatchers.Main)).launch {
            findViewById<TextView>(R.id.activity_main_mainTV).text = fetchSomething()
        }

    }

    private suspend fun fetchSomething(): String {
        delay(2000)
        return "something from the web"
    }

}
