package com.mane.android.doggos_4_u.di

import com.mane.android.doggos_4_u.MainApplication
import com.mane.android.home_domain.di.HomeDomainModule
import com.mane.android.home_ui.di.HomeComponent
import com.mane.android.home_ui.di.HomeFragmentInjectorModule
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(
    modules = [
        AndroidInjectionModule::class,
        MainActivityInjectorModule::class,
        HomeFragmentInjectorModule::class
    ]
)
interface AppComponent {
    fun inject(app: MainApplication)
}