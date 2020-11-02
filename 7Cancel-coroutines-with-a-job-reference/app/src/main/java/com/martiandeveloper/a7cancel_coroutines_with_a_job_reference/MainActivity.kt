package com.martiandeveloper.a7cancel_coroutines_with_a_job_reference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

const val fileUrl = "https://2833069.youcanlearnit.net/lorem_ipsum.txt"

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.doWork()

        mainViewModel.myData.observe(this, {
            findViewById<TextView>(R.id.activity_main_mainTV).text = it
        })

        findViewById<Button>(R.id.activity_main_cancelBTN).setOnClickListener {
            mainViewModel.cancelJob()
        }

    }

}
