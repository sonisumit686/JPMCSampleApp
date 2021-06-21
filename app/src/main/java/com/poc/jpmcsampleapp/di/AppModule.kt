package com.poc.jpmcsampleapp.di

import android.content.Context
import androidx.room.Room
import com.poc.jpmcsampleapp.data.api.ServiceApi
import com.poc.jpmcsampleapp.data.offline.AlbumDatabase
import com.poc.jpmcsampleapp.utils.Constants.BASE_URL
import com.poc.jpmcsampleapp.utils.Constants.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ServiceApi = retrofit.create(ServiceApi::class.java)


    @Provides
    @Singleton
    fun provideRoomDb(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        AlbumDatabase::class.java,
        DB_NAME
    ).build()

    @Provides
    @Singleton
    fun provideDao(dbInstance: AlbumDatabase) = dbInstance.getAlbumDao()
}