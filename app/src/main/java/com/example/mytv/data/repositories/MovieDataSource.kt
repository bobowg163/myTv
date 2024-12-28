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
 * @日期及日间 12/28/24 10:18 AM
 **/
class MovieDataSource @Inject constructor(assetsReader: AssetsReader) {
    private val top250MovieDataReader = CachedDataReader {
        readMovieData(assetsReader, StringConstants.Assets.Top250Movies)
    }
    private val mostPopularMovieDataReader = MovieDataReader {
        readMovieData(assetsReader, StringConstants.Assets.MostPopularMovies).map { it.toMovie() }
    }
    private val movieDataReader = MovieDataReader {
        top250MovieDataReader.read().map { it.toMovie() }
    }
    private var movieWithLongThumbnailDataReader: MovieDataReader = CachedDataReader {
        top250MovieDataReader.read().map {
            it.toMovie(ThumbnailType.Long)
        }
    }
    private val nowPlayingMovieDataReader: MovieDataReader = MovieDataReader {
        readMovieData(assetsReader, StringConstants.Assets.InTheaters).subList(0, 10)
            .map { it.toMovie() }
    }

    suspend fun getMovieList(thumbnailType: ThumbnailType = ThumbnailType.Standard) =
        when (thumbnailType) {
            ThumbnailType.Standard -> movieDataReader.read()
            ThumbnailType.Long -> movieWithLongThumbnailDataReader.read()
        }

    suspend fun getFeaturedMovieList() =
        movieWithLongThumbnailDataReader.read().filterIndexed { index, _ ->
            listOf(1, 3, 5, 7, 9).contains(index)
        }

    suspend fun getTrendingMovieList() = mostPopularMovieDataReader.read().subList(0, 10)
    suspend fun getTop10MovieList() =
        movieWithLongThumbnailDataReader.read().subList(20, 30)

    suspend fun getNowPlayingMovieList() =
        nowPlayingMovieDataReader.read()

    suspend fun getPopularFilmThisWeek() =
        mostPopularMovieDataReader.read().subList(11, 20)

    suspend fun getFavoriteMovieList() =
        movieDataReader.read().subList(0, 28)
}