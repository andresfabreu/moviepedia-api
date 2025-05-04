package com.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

internal const val PARAGRAPH_COMPONENT_TYPE = "paragraph_component"

@Serializable
@SerialName(PARAGRAPH_COMPONENT_TYPE)
internal data class ParagraphComponentResponse(
    val title: TextResponse,
    val paragraph: TextResponse,
) : ComponentResponse()