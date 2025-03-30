package com.example.virtualdecorar.domain

import com.example.virtualdecorar.data.model.DownloadInfo
import com.example.virtualdecorar.data.repository.ModelRepository
import com.example.virtualdecorar.utils.result.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDownloadInfoUseCase @Inject constructor(
    private val modelRepository: ModelRepository,
) {

    suspend operator fun invoke(productId: String): Flow<Result<DownloadInfo>> =
        modelRepository.getDownloadInfo(productId)
}