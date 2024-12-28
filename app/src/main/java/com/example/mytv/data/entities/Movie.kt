package com.example.mytv.data.entities

import com.example.mytv.data.models.MoviesResponseItem

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

fun MoviesResponseItem.toMovie(thumbnailType: ThumbnailType = ThumbnailType.Standard): Movie {
    val thumbnail = when (thumbnailType) {
        ThumbnailType.Long -> image_16_9
        ThumbnailType.Standard -> image_2_3
    }
    return Movie(id, videoUri, subtitleUri, thumbnail, title, fullTitle)
}

enum class ThumbnailType {
    Standard, Long
}