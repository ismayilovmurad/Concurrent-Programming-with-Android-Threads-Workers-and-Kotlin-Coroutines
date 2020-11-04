package com.martiandeveloper.a12set_work_request_constraints

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        Log.i(TAG, "Doing some work!")
        return Result.success()
    }

}
