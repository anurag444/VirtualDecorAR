package com.example.virtualdecorar.di

import android.content.Context
import androidx.room.Room
import com.example.virtualdecorar.data.local.database.VirtualDecorARDatabase
import com.example.virtualdecorar.data.local.database.dao.CategoryAndProductDao
import com.example.virtualdecorar.data.local.database.dao.ProductDao
import com.example.virtualdecorar.utils.constant.Constants
import com.simform.ssfurnicraftar.data.local.database.dao.RemoteKeyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesVirtualDecorARDatabaseDatabase(
        @ApplicationContext context: Context,
    ): VirtualDecorARDatabase = Room.databaseBuilder(
        context,
        VirtualDecorARDatabase::class.java,
        Constants.DATABASE,
    ).build()

    @Provides
    fun providesModelDao(
        database: VirtualDecorARDatabase
    ): ProductDao = database.modelDao()

    @Provides
    fun providesRemoteKeyDao(
        database: VirtualDecorARDatabase
    ): RemoteKeyDao = database.remoteKeyDao()

    @Provides
    fun providesCategoryAndProductDao(
        database: VirtualDecorARDatabase
    ): CategoryAndProductDao = database.categoryAndProductDao()
}
