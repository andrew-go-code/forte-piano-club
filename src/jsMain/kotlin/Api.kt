import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.browser.window

val endpoint = window.location.origin

val jsonClient = HttpClient {
    install(JsonFeature) { serializer = KotlinxSerializer() }
}

suspend fun getBarEventsHolders(): List<BarEventsHolder> {
    return jsonClient.get(endpoint + BarEventsHolder.path)
}

suspend fun getBarMenuHolders(): List<BarMenuHolder> {
    return jsonClient.get(endpoint + BarMenuHolder.path)
}