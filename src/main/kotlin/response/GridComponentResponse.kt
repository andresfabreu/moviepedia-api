package com.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

internal const val GRID_COMPONENT_TYPE = "grid_component_response"

@Serializable
@SerialName(GRID_COMPONENT_TYPE)
internal data class GridComponentResponse(
    val maxItemsInEachRow: Int,
    val components: List<ComponentResponse>,
) : ComponentResponse()