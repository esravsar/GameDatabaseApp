package esra.avsar.gamedatabaseapp.network

object GameApi {

    const val API_KEY = "103818c4107b45eaa7a76b620804749b"

    val retrofitService: GameApiService by lazy {
        RetrofitInstance.retrofit.create(GameApiService::class.java)
    }
}