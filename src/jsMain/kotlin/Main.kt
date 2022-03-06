import components.App
import react.dom.render
import kotlinx.browser.document
import react.create

fun main() {
    val container = document.getElementById("root") ?: error("Couldn't find container!")
    render(App.create(), container)

//    window.onload = {
//        render(document.getElementById("root")) {
//            child(Welcome::class) {
//                attrs {
//                    name = "Kotlin/JS"
//                }
//            }
//        }
//    }
}
