package com.martiandeveloper.a16started_services_and_background_processing_limits

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var myService: MyService

    private val connection = object : ServiceConnection {

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.i(TAG, "Connecting service")

            val binder = service as MyService.MyServiceBinder
            myService = binder.getService()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.activity_main_mainBTN).setOnClickListener {
            myService.doSomething()
        }

    }

    override fun onStart() {

        super.onStart()

        Intent(this, MyService::class.java).also {
            bindService(it, connection, Context.BIND_AUTO_CREATE)
            startService(it)
        }

    }

    override fun onStop() {
        super.onStop()

        unbindService(connection)
    }

}
