package com.patochallen.sample.di

import android.app.Application
import android.content.ContentResolver
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideContext(app: Application): Context = app.baseContext

    @Provides
    @Singleton
    fun provideContentResolver(context: Context): ContentResolver = context.contentResolver
}
