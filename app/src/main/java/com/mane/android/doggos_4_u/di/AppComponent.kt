package com.mane.android.doggos_4_u.di

import com.mane.android.doggos_4_u.MainActivity
import dagger.Component

@Component
interface AppComponent {
    fun inject(app: MainActivity)
}