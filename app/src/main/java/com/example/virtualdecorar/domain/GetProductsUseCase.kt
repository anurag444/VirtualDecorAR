package com.example.virtualdecorar.domain

import androidx.paging.PagingData
import com.example.virtualdecorar.data.model.Category
import com.example.virtualdecorar.data.model.Product
import com.example.virtualdecorar.data.repository.ModelRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val modelRepository: ModelRepository
) {
    suspend operator fun invoke(category: Category): Flow<PagingData<Product>> =
        modelRepository.getModels(category)
}