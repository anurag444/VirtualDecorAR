package com.example.virtualdecorar.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.virtualdecorar.data.local.database.converter.Converters
import com.example.virtualdecorar.data.local.database.dao.CategoryAndProductDao
import com.example.virtualdecorar.data.local.database.dao.ProductDao
import com.example.virtualdecorar.data.local.database.model.ProductEntity
import com.example.virtualdecorar.data.local.database.model.CategoryEntity
import com.example.virtualdecorar.data.local.database.model.CategoryProductCrossRef
import com.example.virtualdecorar.data.local.database.model.RemoteKey
import com.simform.ssfurnicraftar.data.local.database.dao.RemoteKeyDao

@Database(
    entities = [
        ProductEntity::class,
        RemoteKey::class,
        CategoryEntity::class,
        CategoryProductCrossRef::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class VirtualDecorARDatabase : RoomDatabase() {

    abstract fun modelDao(): ProductDao

    abstract fun remoteKeyDao(): RemoteKeyDao

    abstract fun categoryAndProductDao(): CategoryAndProductDao
}
