package com.example.virtualdecorar.data.local

import com.example.virtualdecorar.data.local.database.dao.CategoryAndProductDao
import com.example.virtualdecorar.data.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val categoryAndProductDao: CategoryAndProductDao
) {

    fun getCategories(): List<Category> = Category.entries.dropWhile { it == Category.UNKNOWN }

    suspend fun getProductCategory(productId: String) = withContext(Dispatchers.IO) {
        categoryAndProductDao.getCategoryByProductId(productId)
    }
}