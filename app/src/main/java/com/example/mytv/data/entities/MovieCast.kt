package com.example.mytv.data.entities

/**
 * @项目 myTv
 * ＠包 com.example.mytv.data.entities
 * @作者 bobo
 * @日期及日间 12/27/24 11:30 PM
 **/
data class MovieCast(
    val id: String,
    val characterName: String,
    val realName: String,
    val avatarUrl: String
)

fun MovieCastResponseItem.toMovieCast():MovieCast = MovieCast(id, characterName,realName,avatarUrl)
