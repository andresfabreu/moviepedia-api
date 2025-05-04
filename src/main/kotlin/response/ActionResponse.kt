package com.response

import kotlinx.serialization.Serializable

@Serializable
internal data class ActionResponse(
    val value: String,
    val type: ActionTypeResponse,
)

@Serializable
internal enum class ActionTypeResponse {
    SYSTEM,
    DEEPLINK,
}