package com

import com.dataProvider.getMovie
import com.dataProvider.movieList
import com.dataProvider.toDetailDeeplink
import com.dataProvider.toImageUrl
import com.response.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlin.random.Random

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/movies") {
            call.respond(
                ServerDrivenUiResponse(
                    appBar = AppBarComponentResponse(
                        title = TextResponse(
                            text = "Lançamentos 2025",
                            style = TextStyleResponse.TITLE_LARGE,
                        ),
                        action = null,
                    ),
                    components = if (Random.nextInt() % 2 == 0) {
                        movieList().map { movie ->
                            CardComponentResponse(
                                title = TextResponse(
                                    text = movie.name,
                                    style = TextStyleResponse.TITLE_LARGE,
                                ),
                                image = ImageResponse(
                                    url = movie.image.toImageUrl(),
                                    contentScale = ContentScaleResponse.FILL_WIDTH,
                                ),
                                action = ActionResponse(
                                    value = movie.id.toDetailDeeplink(),
                                    type = ActionTypeResponse.DEEPLINK,
                                ),
                            )
                        }
                    } else {
                        listOf(
                            GridComponentResponse(
                                maxItemsInEachRow = 3,
                                components = movieList().map { movie ->
                                    CardComponentResponse(
                                        title = TextResponse(
                                            text = movie.name,
                                            style = TextStyleResponse.TITLE_SMALL,
                                        ),
                                        image = ImageResponse(
                                            url = movie.image.toImageUrl(),
                                            contentScale = ContentScaleResponse.FILL_HEIGHT,
                                        ),
                                        action = ActionResponse(
                                            value = movie.id.toDetailDeeplink(),
                                            type = ActionTypeResponse.DEEPLINK,
                                        ),
                                    )
                                }
                            )
                        )
                    },
                    bottomBar = null,
                )
            )
        }

        get("/details/{id}") {
            val id = requireNotNull(call.parameters["id"]?.toInt())
            val movie = getMovie(id = id)

            call.respond(
                ServerDrivenUiResponse(
                    appBar = AppBarComponentResponse(
                        title = TextResponse(
                            text = movie.name,
                            style = TextStyleResponse.TITLE_LARGE,
                        ),
                        action = ActionResponse(
                            value = "NAVIGATE_BACK",
                            type = ActionTypeResponse.SYSTEM,
                        ),
                    ),
                    components = listOf(
                        ParagraphComponentResponse(
                            title = TextResponse(
                                text = "SINOPSE",
                                style = TextStyleResponse.TITLE_LARGE,
                            ),
                            paragraph = TextResponse(
                                text = movie.description,
                                style = TextStyleResponse.BODY_MEDIUM,
                            ),
                        )
                    ),
                    bottomBar = null,
                )
            )
        }

        staticResources("/images", "images")
    }
}
