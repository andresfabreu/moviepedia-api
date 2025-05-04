package com.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

internal const val APP_BAR_COMPONENT_TYPE = "app_bar_component"

@Serializable
@SerialName(APP_BAR_COMPONENT_TYPE)
internal data class AppBarComponentResponse(
    val title: TextResponse,
    val action: ActionResponse?,
) : ComponentResponse()