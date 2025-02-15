package com.matthew.pettogether

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.*


@HiltAndroidApp
open class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
//        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
//        }
    }

}