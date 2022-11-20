package com.mane.android.home_ui.di

import com.mane.android.home_domain.di.HomeDomainModule
import com.mane.android.home_ui.DetailsFragment
import com.mane.android.home_ui.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [HomeDomainModule::class])
abstract class HomeFragmentInjectorModule {

    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun bindDetailsFragment(): DetailsFragment
}