package com.alexfuster.weatherglance.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApp: Application() {

    private val logTAG = this::class.java.simpleName


    companion object {
        lateinit var instance: BaseApp
            private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
        registerActivityLifeCycle()
    }

    private fun showActivityLog(activityState: String, currentActivity: Activity) {
        Log.i(logTAG, "$activityState ${currentActivity::class.java.simpleName}")
    }


    private fun registerActivityLifeCycle() {

        this.registerActivityLifecycleCallbacks(object: ActivityLifecycleCallbacks {
            override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                showActivityLog("onActivityCreated", p0)
            }

            override fun onActivityStarted(p0: Activity) {
                showActivityLog("onActivityStarted", p0)
            }

            override fun onActivityResumed(p0: Activity) {
                showActivityLog("onActivityResumed", p0)
            }

            override fun onActivityPaused(p0: Activity) {
                showActivityLog("onActivityPaused", p0)
            }

            override fun onActivityStopped(p0: Activity) {
                showActivityLog("onActivityStopped", p0)
            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
                showActivityLog("onActivitySaveInstanceState", p0)
            }

            override fun onActivityDestroyed(p0: Activity) {
                showActivityLog("onActivityDestroyed", p0)
            }
        })
    }


}