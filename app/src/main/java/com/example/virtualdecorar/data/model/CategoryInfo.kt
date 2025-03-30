package com.example.virtualdecorar.data.model

import com.example.virtualdecorar.data.local.database.model.CategoryEntity


data class CategoryInfo(
    val category: Category,
    val planeType: PlaneType
)

fun CategoryEntity.asExternalModel() = CategoryInfo(
    category = category,
    planeType = planeType
)
