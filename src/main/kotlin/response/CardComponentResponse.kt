package com.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

internal const val CARD_COMPONENT_TYPE = "card_component_response"

@Serializable
@SerialName(CARD_COMPONENT_TYPE)
internal data class CardComponentResponse(
    val image: ImageResponse,
    val title: TextResponse,
    val action: ActionResponse?,
) : ComponentResponse()