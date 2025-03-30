package com.example.virtualdecorar.data.remote.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class NetworkModel(
    @SerializedName("animationCount")
    val animationCount: Int,
    @SerializedName("archives")
    val archives: Archives,
    @SerializedName("categories")
    val categories: List<Category>,
    @SerializedName("commentCount")
    val commentCount: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("description")
    val description: String = "",
    @SerializedName("embedUrl")
    val embedUrl: String,
    @SerializedName("faceCount")
    val faceCount: Int,
    @SerializedName("isAgeRestricted")
    val isAgeRestricted: Boolean,
    @SerializedName("isDownloadable")
    val isDownloadable: Boolean,
    @SerializedName("isProtected")
    val isProtected: Boolean,
    @SerializedName("license")
    val license: License?,
    @SerializedName("likeCount")
    val likeCount: Int = 0,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("soundCount")
    val soundCount: Int,
    @SerializedName("tags")
    val tags: List<Tag>,
    @SerializedName("thumbnails")
    val thumbnails: Thumbnails,
    @SerializedName("uid")
    val uid: String,
    @SerializedName("uri")
    val uri: String,
    @SerializedName("user")
    val user: User,
    @SerializedName("vertexCount")
    val vertexCount: Int,
    @SerializedName("viewCount")
    val viewCount: Int,
    @SerializedName("viewerUrl")
    val viewerUrl: String
)
