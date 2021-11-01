package com.example.lifecycleaware

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.LifecycleOwner
import java.time.Instant
import java.time.format.DateTimeFormatter

class DemoObserver: LifecycleObserver  {

    private val LOG_TAG = "DemoObserver"
    val formatter = DateTimeFormatter
        .ofPattern("H:mm:ss.SSSS")


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(): String {
        Log.i(LOG_TAG, "onResume")
        val response = "onResume was fired on $formatter\n"
        return response

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(): String {
        Log.i(LOG_TAG, "onPause")
        val response = "onPause was fired on $formatter\n"
        return response
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(): String {
        Log.i(LOG_TAG, "onCreate was fired on $formatter")
        val response = "onCreate was fired on $formatter\n"
        return response
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(): String {
        Log.i(LOG_TAG, "onStart")
        val response = "onStart was fired on $formatter\n"
        return response
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(): String {

        Log.i(LOG_TAG, "onStop was called on $formatter")
        val response = "onStop was fired on $formatter\n"
        return response
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(): String {

        Log.i(LOG_TAG, "onDestroy")
        val response = "onDestroy was fired on $formatter\n"
        return response
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner, event: Lifecycle.Event): String {
        Log.i(LOG_TAG, owner.lifecycle.currentState.name)
        val response = owner.lifecycle.currentState.name + " was fired on $formatter\n"
        return response
    }

}