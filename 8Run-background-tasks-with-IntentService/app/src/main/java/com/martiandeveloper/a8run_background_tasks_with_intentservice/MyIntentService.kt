package com.martiandeveloper.a8run_background_tasks_with_intentservice

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO =
    "com.martiandeveloper.a8run_background_tasks_with_intentservice.action.FOO"
private const val ACTION_BAZ =
    "com.martiandeveloper.a8run_background_tasks_with_intentservice.action.BAZ"

private const val EXTRA_PARAM1 =
    "com.martiandeveloper.a8run_background_tasks_with_intentservice.extra.PARAM1"
private const val EXTRA_PARAM2 =
    "com.martiandeveloper.a8run_background_tasks_with_intentservice.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.

 * helper methods.

 */

class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        when (intent?.action) {
            ACTION_FOO -> {
                val param1 = intent.getStringExtra(EXTRA_PARAM1)
                val param2 = intent.getStringExtra(EXTRA_PARAM2)
                if (param1 != null) {
                    if (param2 != null) {
                        handleActionFoo(param1, param2)
                    }
                }
            }
            ACTION_BAZ -> {
                val param1 = intent.getStringExtra(EXTRA_PARAM1)
                val param2 = intent.getStringExtra(EXTRA_PARAM2)
                if (param1 != null) {
                    if (param2 != null) {
                        handleActionBaz(param1, param2)
                    }
                }
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionFoo(param1: String, param2: String) {
        Log.i(TAG, "handleActionFoo: $param1, $param2")
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionBaz(param1: String, param2: String) {
        Log.i(TAG, "handleActionBaz: $param1, $param2")
    }

    companion object {
        /**
         * Starts this service to perform action Foo with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        @JvmStatic
        fun startActionFoo(context: Context, param1: String, param2: String) {
            val intent = Intent(context, MyIntentService::class.java).apply {
                action = ACTION_FOO
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }

        /**
         * Starts this service to perform action Baz with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        @JvmStatic
        fun startActionBaz(context: Context, param1: String, param2: String) {
            val intent = Intent(context, MyIntentService::class.java).apply {
                action = ACTION_BAZ
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }
    }
}
