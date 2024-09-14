package io.demo.dto

data class News(
    val id: Long,
    val title: String,
    val place: String,
    val description: String,
    val siteUrl: String,
    val favoritesCount: Int,
    val commentsCount: Int
)
