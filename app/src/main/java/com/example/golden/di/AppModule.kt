package com.example.golden.di

import com.example.golden.data.api.Network
import com.example.golden.data.repository.PricesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePricesRepository(): PricesRepository {
        val accessToken = "JNAUJKBTHUMGD20NEOMJ7320NEOMJ"
        return PricesRepository(accessToken)
    }
}
