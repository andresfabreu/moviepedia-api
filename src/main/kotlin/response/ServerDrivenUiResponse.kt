package com.response

import kotlinx.serialization.Serializable

@Serializable
internal data class ServerDrivenUiResponse(
    val appBar: ComponentResponse?,
    val components: List<ComponentResponse>,
    val bottomBar: ComponentResponse?,
)