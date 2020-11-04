package com.martiandeveloper.a12set_work_request_constraints

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraints = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()

        val workRequest = OneTimeWorkRequestBuilder<MyWorker>().setConstraints(constraints).build()
        WorkManager.getInstance(applicationContext).enqueue(workRequest)
    }

}
