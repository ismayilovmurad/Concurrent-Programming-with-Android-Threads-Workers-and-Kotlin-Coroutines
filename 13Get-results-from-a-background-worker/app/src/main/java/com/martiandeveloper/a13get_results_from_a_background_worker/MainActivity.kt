package com.martiandeveloper.a13get_results_from_a_background_worker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.work.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraints =
            Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()

        val workRequest = OneTimeWorkRequestBuilder<MyWorker>().setConstraints(constraints).build()
        val workManager = WorkManager.getInstance(applicationContext)
        workManager.enqueue(workRequest)

        workManager.getWorkInfoByIdLiveData(workRequest.id).observe(this, {

            if (it.state == WorkInfo.State.SUCCEEDED) {
                val result = it.outputData.getString(DATA_KEY)
                findViewById<TextView>(R.id.activity_main_mainTV).text = result ?: "Null"
            }

        })

    }

}
