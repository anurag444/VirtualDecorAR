package com.example.virtualdecorar.data.local.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.virtualdecorar.data.remote.model.NetworkModel
import com.example.virtualdecorar.utils.constant.Constants

@Entity(
    tableName = Constants.TABLE_PRODUCT
)
data class ProductEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    @ColumnInfo(defaultValue = "")
    val description: String,
    val thumbnail: String,
    @ColumnInfo(defaultValue = "0")
    val likes: Int,
    @ColumnInfo(defaultValue = "NULL")
    val license: String?
)

fun NetworkModel.asEntity() = ProductEntity(
    id = uid,
    name = name,
    description = description,
    thumbnail = thumbnails.images.run { firstOrNull { it.width == 720 } ?: last() }.url,
    likes = likeCount,
    license = license?.label
)