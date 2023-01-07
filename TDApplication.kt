package com.kyoungae.myfavoriterestaurants

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TDApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}