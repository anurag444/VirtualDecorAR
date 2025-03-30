package com.example.virtualdecorar.data.model

import com.example.virtualdecorar.data.remote.model.NetworkDownloadInfo

data class DownloadInfo(
    val url: String,
    val totalSize: Long
)

fun NetworkDownloadInfo.asExternalModel() = DownloadInfo(
    url = url,
    totalSize = size
)
