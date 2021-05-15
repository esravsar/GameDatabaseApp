package esra.avsar.gamedatabaseapp.network

import esra.avsar.gamedatabaseapp.model.GameResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApiService {

    @GET("games")
    suspend fun getGames(@Query("key") key: String): GameResponse?
}
