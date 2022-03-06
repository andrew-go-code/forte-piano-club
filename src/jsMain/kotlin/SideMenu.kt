import csstype.px
import kotlinx.js.jso
import mui.icons.material.LibraryMusic
import mui.material.*
import react.FC
import react.Props
import react.create
import react.dom.aria.AriaRole

external interface SideMenuProps : Props {
    var isOpen: Boolean?
    var onClose: () -> Unit
}

val SideMenu = FC<SideMenuProps> { props ->
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
                ListItem {
                    asDynamic().button = true
                    ListItemIcon {
//                        LibraryMusic()
                        mui.icons.material.Menu()
                    }
                    ListItemText {
                        +"Афиша"
                    }
                }

            }
        }
    }
}