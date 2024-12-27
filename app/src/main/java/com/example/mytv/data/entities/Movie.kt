package com.example.mytv.data.entities

/**
 * @项目 myTv
 * ＠包 com.example.mytv.data.entities
 * @作者 bobo
 * @日期及日间 12/27/24 11:26 PM
 **/
data class Movie(
    val id: String,
    val videoUri: String,
    val subtitleUri: String?,
    val posterUri: String,
    val name: String,
    val description: String
)

enum class ThumbnailType {
    Standard, Long
}