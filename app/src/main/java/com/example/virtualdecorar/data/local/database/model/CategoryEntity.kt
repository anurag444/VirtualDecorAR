package com.example.virtualdecorar.data.local.database.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.virtualdecorar.data.model.Category
import com.example.virtualdecorar.data.model.CategoryInfo
import com.example.virtualdecorar.data.model.PlaneType
import com.example.virtualdecorar.utils.constant.Constants

@Entity(
    tableName = Constants.TABLE_CATEGORY,
    indices = [
        Index(value = ["category"], unique = true)
    ]
)
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val category: Category,
    val planeType: PlaneType
)

fun CategoryInfo.asEntity() = CategoryEntity(category = category, planeType = planeType)