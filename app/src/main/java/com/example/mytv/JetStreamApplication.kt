package com.example.mytv

import android.app.Application
import com.example.mytv.data.repositories.MovieRepository
import com.example.mytv.data.repositories.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent

/**
 * @项目 myTv
 * ＠包 com.example.mytv
 * @作者 bobo
 * @日期及日间 12/28/24 11:38 AM
 **/

@HiltAndroidApp
class JetStreamApplication : Application()

@InstallIn(SingletonComponent::class)
@Module
abstract class MovieRepositoryModule {
    @Binds
    abstract fun bindMovieRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository
}
