package com.martiandeveloper.a7cancel_coroutines_with_a_job_reference

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import java.net.URL
import java.nio.charset.Charset

class MainViewModel : ViewModel() {

    val myData = MutableLiveData<String>()
    private lateinit var job: Job


    fun doWork() {
        job = viewModelScope.launch {
            myData.value = fetchSomething()
        }
    }

    private suspend fun fetchSomething(): String {

        delay(3000)

        return withContext(Dispatchers.IO) {
            return@withContext URL(fileUrl).readText(Charset.defaultCharset())
        }

    }

    fun cancelJob() {

        try {
            job.cancel()
        } catch (e: UninitializedPropertyAccessException) {
        }

        myData.value = "Job cancelled"

    }

}
