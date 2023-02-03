package com.kyoungae.myfavoriterestaurants.di

import android.content.Context
import com.kyoungae.myfavoriterestaurants.data.DefaultTDRepository
import com.kyoungae.myfavoriterestaurants.data.TDDataSource
import com.kyoungae.myfavoriterestaurants.data.TDRepository
import com.kyoungae.myfavoriterestaurants.data.local.TDLocalDataSource
import com.kyoungae.myfavoriterestaurants.data.remote.TDRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.daum.mf.map.api.MapView
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class LocalTDDataSource

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RemoteTDDataSource

@Module
@InstallIn(SingletonComponent::class)
class TDDataSourceModules{

    @Singleton
    @LocalTDDataSource
    @Provides
    fun providesTDLocalDataSource(): TDDataSource = TDLocalDataSource()

    @Singleton
    @RemoteTDDataSource
    @Provides
    fun providesTDRemoteDataSource(): TDDataSource = TDRemoteDataSource()
}


@Module
@InstallIn(SingletonComponent::class)
class TDRepositoryModule{

    @Singleton
    @Provides
    fun providesTDRepository(
        @LocalTDDataSource tdLocalDataSource: TDDataSource,
        @RemoteTDDataSource tdRemoteDataSource: TDDataSource,
    ): TDRepository = DefaultTDRepository(tdLocalDataSource,tdRemoteDataSource)
}