
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BarEventsHolder(
    @Contextual
    @SerialName("_id")
    val id: String? = null,
    val year: Int,
    val month: String,
    val events: List<BarEvent>
) {
    @Serializable
    data class BarEvent(
        val name: String,
        val genre: String,
        val details: String,
        val imageSrc: String
    )

    companion object {
        const val path = "/barEvents"
    }
}