package components

import mui.material.Box
import mui.material.Container
import mui.material.CssBaseline
import react.FC
import react.Props
import react.useState

val App = FC<Props> {
    var activeMenuItem by useState(AppMenuItem.EVENTS)
    var isSideMenuOpen by useState(false)

    CssBaseline()
    Container {
        ThemeModule {
            AppMenuBar {
                onSideMenuButtonClick = {
                    isSideMenuOpen = true
                }
            }

            Box {
                AppMenuDrawer {
                    isOpen = isSideMenuOpen
                    onClose = {
                        isSideMenuOpen = false
                    }
                    onSelectedAppMenuDrawerItem = { activeItem -> activeMenuItem = activeItem }
                }
                when(activeMenuItem) {
                    AppMenuItem.EVENTS -> BarEvents()
                    else -> BarMenu()
                }
            }

        }
    }
}

enum class AppMenuItem(
    val strName: String
) {
    EVENTS("Events"), MENU("Bar menu")
}