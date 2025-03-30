package com.example.virtualdecorar.domain

import com.example.virtualdecorar.data.model.Category
import com.example.virtualdecorar.data.repository.ModelRepository
import javax.inject.Inject

class GetProductCategoriesUseCase @Inject constructor(
    private val modelRepository: ModelRepository
) {

    operator fun invoke(): List<Category> = modelRepository.getCategories()
}
