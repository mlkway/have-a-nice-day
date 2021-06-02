package com.raywenderlich.home_challenge.data

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class DomusItem(
    @Json(name = "category")
    val category: String,
    @Json(name = "cover")
    val cover: String,
    @Json(name = "created_at")
    val createdAt: Long,
    @Json(name = "descriptionEN")
    val descriptionEN: String,
    @Json(name = "descriptionKA")
    val descriptionKA: String,
    @Json(name = "descriptionRU")
    val descriptionRU: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "isLast")
    val isLast: Boolean,
    @Json(name = "publish_date")
    val publishDate: String,
    @Json(name = "published")
    val published: Int,
    @Json(name = "titleEN")
    val titleEN: String,
    @Json(name = "titleKA")
    val titleKA: String,
    @Json(name = "titleRU")
    val titleRU: String,
    @Json(name = "updated_at")
    val updatedAt: Long
)
