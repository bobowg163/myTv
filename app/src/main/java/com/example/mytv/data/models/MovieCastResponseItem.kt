package com.example.mytv.data.models

import kotlinx.serialization.Serializable

/**
 * @项目 myTv
 * ＠包 com.example.mytv.data.models
 * @作者 bobo
 * @日期及日间 12/28/24 12:08 AM
 **/

@Serializable
data class MovieCastResponseItem(
    val id: String,
    val characterName: String,
    val realName: String,
    val avatarUrl: String,
)
