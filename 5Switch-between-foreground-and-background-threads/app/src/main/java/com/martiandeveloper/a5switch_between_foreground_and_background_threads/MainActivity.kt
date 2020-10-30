package com.martiandeveloper.a5switch_between_foreground_and_background_threads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import java.nio.charset.Charset

const val fileUrl = "https://2833069.youcanlearnit.net/lorem_ipsum.txt"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runCode()
    }

    private fun runCode() {

        CoroutineScope(Dispatchers.Main).launch {
            findViewById<TextView>(R.id.activity_main_mainTV).text = fetchSomething() ?: "Null"
        }

    }

    private suspend fun fetchSomething(): String? {

        /*var contents: String? = null

        withContext(Dispatchers.IO) {
            contents = URL(fileUrl).readText(Charset.defaultCharset())
        }

        return contents*/

        //todo withContext function is capable of returning a value
        return withContext(Dispatchers.IO) {
            return@withContext URL(fileUrl).readText(Charset.defaultCharset())
        }

    }

}
