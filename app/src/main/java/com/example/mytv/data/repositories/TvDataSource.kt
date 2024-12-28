package com.example.mytv.data.repositories

import com.example.mytv.data.entities.ThumbnailType
import com.example.mytv.data.entities.toMovie
import com.example.mytv.data.util.AssetsReader
import com.example.mytv.data.util.StringConstants
import javax.inject.Inject

/**
 * @项目 myTv
 * ＠包 com.example.mytv.data.repositories
 * @作者 bobo
 * @日期及日间 12/28/24 11:05 AM
 **/
class TvDataSource @Inject constructor(assetsReader: AssetsReader) {
    private val mostPopularTvShowReader = CachedDataReader {
        readMovieData(assetsReader, StringConstants.Assets.MostPopularTVShows)
    }

    suspend fun getTvShowList() =
        mostPopularTvShowReader.read().subList(0, 5).map { it.toMovie(ThumbnailType.Long) }

    suspend fun getBingeWatchDramaList() =
        mostPopularTvShowReader.read().subList(0, 15).map { it.toMovie() }
}