package com.example.virtualdecorar.data.repository

import androidx.paging.PagingData
import com.example.virtualdecorar.data.model.Category
import com.example.virtualdecorar.data.model.CategoryInfo
import com.example.virtualdecorar.data.model.DownloadInfo
import com.example.virtualdecorar.data.model.Product
import com.example.virtualdecorar.data.remote.model.DownloadStatus
import com.example.virtualdecorar.utils.result.Result
import kotlinx.coroutines.flow.Flow
import java.nio.file.Path

interface ModelRepository {
    suspend fun getModels(category: Category): Flow<PagingData<Product>>

    fun getCategories(): List<Category>

    suspend fun getProductCategory(productId: String): CategoryInfo

    suspend fun getDownloadInfo(modelId: String): Flow<Result<DownloadInfo>>

    suspend fun download(path: Path, url: String): Flow<DownloadStatus>
}