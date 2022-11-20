package com.mane.android.doggos_4_u.di

import com.mane.android.doggos_4_u.MainActivity
import com.mane.android.home_ui.di.HomeFragmentInjectorModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityInjectorModule {

    @ContributesAndroidInjector(modules = [HomeFragmentInjectorModule::class])
    abstract fun bindMainActivity(): MainActivity
}
