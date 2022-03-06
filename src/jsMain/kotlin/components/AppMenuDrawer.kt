package components
import csstype.px
import kotlinx.js.jso
import mui.icons.material.LibraryMusic
import mui.icons.material.MenuBook
import mui.icons.material.SvgIconComponent
import mui.material.*
import react.FC
import react.Props
import react.dom.aria.AriaRole

external interface SideMenuProps : Props {
    var isOpen: Boolean?
    var onClose: () -> Unit
    var onSelectedAppMenuDrawerItem: (activeItem: AppMenuItem) -> Unit
}

val AppMenuDrawer = FC<SideMenuProps> { props ->
    Drawer {
        open = props.isOpen ?: false
        onClose = { _, _ ->
            props.onClose()
        }

        Box {
            sx = jso {
                role = AriaRole.presentation
                width = 250.px
            }
            List {
                appMenuDrawerHolders.forEach {
                    ListItem {
                        asDynamic().button = true
                        asDynamic().onClick = {
                            props.onSelectedAppMenuDrawerItem(it.appMenuItem)
                        }
                        ListItemIcon {
                            it.icon()

                        }
                        ListItemText {
                            +it.name
                        }
                    }
                }
            }
        }
    }
}

private data class AppMenuDrawerHolder(
    val appMenuItem: AppMenuItem,
    val name: String,
    val icon: SvgIconComponent,
)

private val appMenuDrawerHolders = listOf(
    AppMenuDrawerHolder(
        appMenuItem = AppMenuItem.EVENTS,
        name = AppMenuItem.EVENTS.strName,
        icon = LibraryMusic
    ),
    AppMenuDrawerHolder(
        appMenuItem = AppMenuItem.MENU,
        name = AppMenuItem.MENU.strName,
        icon = MenuBook
    ),
)