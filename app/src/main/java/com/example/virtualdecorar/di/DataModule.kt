package com.example.virtualdecorar.di

import com.example.virtualdecorar.data.repository.ModelRepository
import com.example.virtualdecorar.data.repository.ModelRepositoryImpl
import com.example.virtualdecorar.data.utils.ConnectivityManagerNetworkMonitor
import com.example.virtualdecorar.data.utils.FileHelper
import com.example.virtualdecorar.data.utils.FileHelperImpl
import com.example.virtualdecorar.data.utils.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindNetworkMonitor(networkMonitor: ConnectivityManagerNetworkMonitor): NetworkMonitor

    @Binds
    fun bindsFileHelper(fileHelper: FileHelperImpl):  FileHelper

    @Binds
    fun bindsModelRepository(modelRepository: ModelRepositoryImpl): ModelRepository
}