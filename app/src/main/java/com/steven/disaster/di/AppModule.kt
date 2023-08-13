package com.steven.disaster.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.work.WorkManager
import com.steven.disaster.utils.WaterLevelNotification
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private val Context.prefDataStore: DataStore<Preferences> by preferencesDataStore("settings")

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataStorePreference(context: Application): DataStore<Preferences> {
        return context.prefDataStore
    }

    @Provides
    @Singleton
    fun provideWaterLevelNotification(context: Application): WaterLevelNotification =
        WaterLevelNotification(context)

    @Provides
    @Singleton
    fun provideWorkManager(context: Application): WorkManager = WorkManager.getInstance(context)
}