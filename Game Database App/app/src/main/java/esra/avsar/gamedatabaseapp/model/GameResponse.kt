package esra.avsar.gamedatabaseapp.model

import com.squareup.moshi.Json

data class GameResponse (
    @Json(name = "results")
    val results : List<Game>?
)