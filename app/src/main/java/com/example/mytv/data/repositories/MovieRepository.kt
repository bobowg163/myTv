package com.example.mytv.data.repositories

import com.example.mytv.data.entities.MovieCategoryDetails
import com.example.mytv.data.entities.MovieCategoryList
import com.example.mytv.data.entities.MovieDetails
import com.example.mytv.data.entities.MovieList
import kotlinx.coroutines.flow.Flow

/**
 * @项目 myTv
 * ＠包 com.example.mytv.data.repositories
 * @作者 bobo
 * @日期及日间 12/28/24 10:58 AM
 **/
interface MovieRepository {
    fun getFeaturedMovies(): Flow<MovieList>
    fun getTrendingMovies(): Flow<MovieList>
    fun getTop10Movies(): Flow<MovieList>
    fun getNowPlayingMovies(): Flow<MovieList>
    fun getMovieCategories(): Flow<MovieCategoryList>
    suspend fun getMovieCategoryDetails(categoryId: String): MovieCategoryDetails
    suspend fun getMovieDetails(movieId: String): MovieDetails
    suspend fun searchMovies(query: String): MovieList
    fun getMoviesWithLongThumbnail(): Flow<MovieList>
    fun getMovies(): Flow<MovieList>
    fun getPopularFilmsThisWeek(): Flow<MovieList>
    fun getTVShows(): Flow<MovieList>
    fun getBingeWatchDramas(): Flow<MovieList>
    fun getFavouriteMovies(): Flow<MovieList>
}