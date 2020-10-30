package com.martiandeveloper.a6run_coroutines_in_a_viewmodel_class

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import java.nio.charset.Charset

class MainViewModel : ViewModel() {

    val myData = MutableLiveData<String>()


    fun doWork() {
        viewModelScope.launch {
            myData.value = fetchSomething()
        }
    }

    private suspend fun fetchSomething(): String {

        return withContext(Dispatchers.IO) {
            return@withContext URL(fileUrl).readText(Charset.defaultCharset())
        }

    }

}
