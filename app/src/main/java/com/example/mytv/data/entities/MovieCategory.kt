package com.example.mytv.data.entities

import com.example.mytv.data.models.MovieCategoriesResponseItem

/**
 * @项目 myTv
 * ＠包 com.example.mytv.data.entities
 * @作者 bobo
 * @日期及日间 12/28/24 9:00 AM
 **/
data class MovieCategory(
    val id: String,
    val name: String
)

fun MovieCategoriesResponseItem.toMovieCategory(): MovieCategory = MovieCategory(id, name)
