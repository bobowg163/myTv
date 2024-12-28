package com.example.mytv.data.repositories

import com.example.mytv.data.entities.toMovieCategory
import com.example.mytv.data.util.AssetsReader
import com.example.mytv.data.util.StringConstants
import javax.inject.Inject

/**
 * @项目 myTv
 * ＠包 com.example.mytv.data.repositories
 * @作者 bobo
 * @日期及日间 12/28/24 10:14 AM
 **/
class MovieCategoryDataSource @Inject constructor(assetsReader: AssetsReader) {
    private val movieCategoryDataReader = CachedDataReader {
        readMovieCategoryData(assetsReader, StringConstants.Assets.MovieCategories).map {
            it.toMovieCategory()
        }
    }

    suspend fun getMovieCategoryList() = movieCategoryDataReader.read()
}