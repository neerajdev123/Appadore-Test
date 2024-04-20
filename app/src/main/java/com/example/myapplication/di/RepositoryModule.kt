package com.example.myapplication.di

import com.example.myapplication.repository.MeetingRepository
import com.example.myapplication.repository.MeetingRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    @ViewModelScoped
    abstract fun bindMeetingRepository(impl: MeetingRepositoryImpl): MeetingRepository


}