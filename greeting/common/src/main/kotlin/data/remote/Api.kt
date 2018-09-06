package data.remote

import data.model.DeathStar
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get

//expect class HttpEngine

object Api {

//    private val engine: HttpClientEngine = HttpEngine()
//    internal expect val ApplicationDispatcher: CoroutineDispatcher

    const val deathStarUrl = "https://swapi.co/api/starships/9"

    private val client = HttpClient() {
        install(JsonFeature)

    }

    suspend fun getDeathStar() = client.get<DeathStar>(path = deathStarUrl)
}
