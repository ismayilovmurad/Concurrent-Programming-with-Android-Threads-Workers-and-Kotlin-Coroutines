package com.martiandeveloper.a8run_background_tasks_with_intentservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runCode()
    }

    private fun runCode() {
        MyIntentService.startActionFoo(this, "Param1", "Param2")
    }

}
