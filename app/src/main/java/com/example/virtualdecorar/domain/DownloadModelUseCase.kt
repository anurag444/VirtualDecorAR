package com.example.virtualdecorar.domain

import com.example.virtualdecorar.data.remote.model.DownloadStatus
import com.example.virtualdecorar.data.repository.ModelRepository
import kotlinx.coroutines.flow.Flow
import java.nio.file.Path
import javax.inject.Inject

class DownloadModelUseCase @Inject constructor(
    private val modelRepository: ModelRepository,
) {

    suspend operator fun invoke(path: Path, url: String): Flow<DownloadStatus> =
        modelRepository.download(path, url)
}