package com.martiandeveloper.a10send_results_from_jobintentservice_to_the_ui

import android.app.Activity
import android.content.Intent
import android.content.Context
import android.os.Bundle
import android.os.ResultReceiver
import android.util.Log
import androidx.core.app.JobIntentService
import java.net.URL
import java.nio.charset.Charset

private const val EXTRA_FILE_URL =
    "com.martiandeveloper.a10send_results_from_jobintentservice_to_the_ui.extra.FILE_URL"

private const val JOB_ACTION =
    "com.martiandeveloper.a10send_results_from_jobintentservice_to_the_ui.extra.JOB_ACTION"
private const val JOB_ID = 1000

class MyIntentService : JobIntentService() {

    override fun onHandleWork(intent: Intent) {

        if (intent.action == JOB_ACTION) {
            val url = URL(intent.getStringExtra(EXTRA_FILE_URL))
            val contents = url.readText(Charset.defaultCharset())
            Log.i(TAG, contents)

            val bundle = Bundle()
            bundle.putString(FILE_CONTENTS_KEY, contents)

            val receiver = intent.getParcelableExtra<ResultReceiver>(RECEIVER_KEY)
            receiver?.send(Activity.RESULT_OK, bundle)
        }

    }

    companion object {

        fun startAction(context: Context, fileUrl: String, receiver: ResultReceiver) {

            val intent = Intent(context, MyIntentService::class.java).apply {
                action = JOB_ACTION
                putExtra(RECEIVER_KEY, receiver)
                putExtra(EXTRA_FILE_URL, fileUrl)
            }

            enqueueWork(context, MyIntentService::class.java, JOB_ID, intent)

        }

    }

}
