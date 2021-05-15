package esra.avsar.gamedatabaseapp.model

import android.icu.text.StringSearch
import com.squareup.moshi.Json

data class Game (
    @Json(name = "name")
    val name : String?,
    @Json(name = "rating")
    val rating : String?,
    @Json(name = "released")
    val released : String?,
    @Json(name = "background_image")
    val backgroundImage : String?
)