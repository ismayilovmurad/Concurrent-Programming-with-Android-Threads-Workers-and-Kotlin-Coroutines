package com.martiandeveloper.a9upgrade_intentservice_to_jobintentservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyIntentService.startActionFoo(this, "Param1", "Param2")
    }

}
