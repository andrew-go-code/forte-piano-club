import react.*
import kotlinx.coroutines.*
import mui.material.Box
import mui.material.Container
import mui.material.CssBaseline
import react.dom.html.ReactHTML.h1

private val scope = MainScope()

val App = FC<Props> {
    var activeMenuItem by useState("poster")
    var isSideMenuOpen by useState(false)

    CssBaseline()
    Container {
        ThemeModule {
            MainMenu {
                onSelectedMainMenuItem = { activeItem -> activeMenuItem = activeItem }
                onSideMenuButtonClick = {
                    isSideMenuOpen = true
                }
            }

            Box {
                SideMenu {
                    isOpen = isSideMenuOpen
                    onClose = {
                        isSideMenuOpen = false
                    }
                }
                if (activeMenuItem == "poster") {
                    Poster()
                } else {
                    MainMenu()
                }
            }

        }
    }

}