package com.martiandeveloper.a15create_and_run_a_bound_service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    private val binder = MyServiceBinder()

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    fun doSomething() {
        Log.i(TAG, "The service is doing something!")
    }

    inner class MyServiceBinder : Binder() {
        fun getService() = this@MyService
    }

}
