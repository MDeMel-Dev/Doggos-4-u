package com.mane.android.home_ui.di

import com.mane.android.home_domain.di.HomeDomainModule
import dagger.Subcomponent

@Subcomponent(modules = [HomeFragmentInjectorModule::class, HomeDomainModule::class])
interface HomeComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): HomeComponent
    }
}