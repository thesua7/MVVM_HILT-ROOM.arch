package com.thesua7.mvvm_hilt_roomarch.di

import android.app.Application
import android.content.Context
import com.thesua7.mvvm_hilt_roomarch.databaseModel.AppDao
import com.thesua7.mvvm_hilt_roomarch.databaseModel.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun getDB(context: Application) : AppDatabase{
        return AppDatabase.getDBInstance(context)
    }

    @Singleton
    @Provides
    fun getDao(appDatabase: AppDatabase): AppDao{
        return appDatabase.getDao()
    }
}