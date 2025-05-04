package com.response

import kotlinx.serialization.Serializable

@Serializable
internal data class ImageResponse(
    val url: String,
    val contentScale: ContentScaleResponse,
)

@Serializable
internal enum class ContentScaleResponse {
    FILL_HEIGHT,
    FILL_WIDTH,
    FIT,
}