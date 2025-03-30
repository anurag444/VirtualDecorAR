package com.example.virtualdecorar.data.local.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.virtualdecorar.utils.constant.Constants

@Entity(
    tableName = Constants.TABLE_CATEGORY_PRODUCT,
    primaryKeys = ["categoryId", "productId"],
    foreignKeys = [
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ProductEntity::class,
            parentColumns = ["id"],
            childColumns = ["productId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CategoryProductCrossRef(
    @ColumnInfo(index = true)
    val categoryId: Long,
    @ColumnInfo(index = true)
    val productId: String
)