package com.example.virtualdecorar.domain

import com.example.virtualdecorar.data.model.CategoryInfo
import com.example.virtualdecorar.data.repository.ModelRepository
import javax.inject.Inject

class GetProductCategoryUseCase @Inject constructor(
    private val modelRepository: ModelRepository,
) {

    suspend operator fun invoke(productId: String): CategoryInfo =
        modelRepository.getProductCategory(productId)
}