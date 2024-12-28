package com.example.mytv.data.entities

/**
 * @项目 myTv
 * ＠包 com.example.mytv.data.entities
 * @作者 bobo
 * @日期及日间 12/28/24 9:02 AM
 **/
data class MovieCategoryDetails(
    val id:String,
    val name:String,
    val movies:MovieList,
)


typealias MovieList = List<Movie>
