package com.example.myapplication.di

import com.example.myapplication.data.StaticDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataSourceModule {

    @Provides
    @Singleton
    fun provideStaticDataSource(): StaticDataSource {
        return StaticDataSource()
    }

}