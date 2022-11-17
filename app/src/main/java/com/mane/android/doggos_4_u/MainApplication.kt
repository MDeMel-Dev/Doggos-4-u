package com.mane.android.doggos_4_u

import android.app.Application
import com.mane.android.doggos_4_u.di.DaggerAppComponent

class MainApplication : Application() {
    // Reference to the application graph that is used across the whole app
    val appComponent = DaggerAppComponent.create()
}