package com.test.wadiz

import android.app.Application
import timber.log.Timber

/**
 * Created on 2022-09-01
 */
class AppApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}