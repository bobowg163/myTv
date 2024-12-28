package com.example.mytv.data.repositories

import com.example.mytv.data.entities.toMovieCast
import com.example.mytv.data.util.AssetsReader
import com.example.mytv.data.util.StringConstants
import javax.inject.Inject

/**
 * @项目 myTv
 * ＠包 com.example.mytv.data.repositories
 * @作者 bobo
 * @日期及日间 12/28/24 9:54 AM
 **/
class MovieCastDataSource @Inject constructor(assetsReader: AssetsReader) {
    private val movieCastDataReader = CachedDataReader{
        readMovieCastData(assetsReader,StringConstants.Assets.MovieCast).map { it.toMovieCast() }
    }
    suspend fun getMovieCastList() = movieCastDataReader.read()
}