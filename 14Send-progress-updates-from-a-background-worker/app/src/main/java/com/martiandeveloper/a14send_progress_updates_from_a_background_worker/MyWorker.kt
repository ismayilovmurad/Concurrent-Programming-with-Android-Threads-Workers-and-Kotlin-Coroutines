package com.martiandeveloper.a14send_progress_updates_from_a_background_worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.net.URL
import java.nio.charset.Charset

class MyWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {

        return withContext(Dispatchers.IO) {
            setProgress(workDataOf(MESSAGE_KEY to "Doing some work"))
            delay(1000)
            setProgress(workDataOf(MESSAGE_KEY to "Doing some more work"))
            delay(1000)
            setProgress(workDataOf(MESSAGE_KEY to "Almost done"))
            delay(1000)

            val url = URL(FILE_URL)
            val data = url.readText(Charset.defaultCharset())

            val result = workDataOf(DATA_KEY to data)
            return@withContext Result.success(result)
        }

    }

}
