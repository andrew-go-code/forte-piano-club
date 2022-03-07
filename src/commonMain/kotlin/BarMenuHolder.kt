import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BarMenuHolder(
    @Contextual
    @SerialName("_id")
    val id: String? = null,
    val category: String,
    val items: List<BarMenuItem>
) {
    @Serializable
    data class BarMenuItem(
        val name: String,
        val description: String,
        val calories: Int,
        val imageSrc: String,
        val price: Int
    )

    companion object {
        const val path = "/barMenu"
    }
}