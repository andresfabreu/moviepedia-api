package com.response

import kotlinx.serialization.Serializable

@Serializable
internal data class TextResponse(
    val text: String,
    val style: TextStyleResponse,
)

@Serializable
internal enum class TextStyleResponse {
    TITLE_SMALL,
    TITLE_LARGE,
    BODY_MEDIUM,
}