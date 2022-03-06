import csstype.*
import kotlinx.js.jso
import mui.icons.material.*
import mui.material.*
import mui.material.Size
import mui.system.Breakpoint
import react.*
import react.dom.aria.ariaLabel
import react.dom.html.ReactHTML

external interface MainMenuProps : Props {
    //    var selectedMainMenuItem: String?
    var onSelectedMainMenuItem: (activeItem: String) -> Unit
    var onSideMenuButtonClick: () -> Unit
}

val MainMenu = FC<MainMenuProps> { props ->
    var theme by useContext(ThemeContext)

    Box {


        AppBar {
            position = AppBarPosition.static
            Toolbar {
                Typography {
                    sx = jso {
//                        flexGrow = FlexGrow(1.0)
                        marginRight = 2.px
//                        display = jso {
//                            siz
//                        }

                    }
                    variant = "h6"
                    noWrap = true
                    component = ReactHTML.div

                    +"Forte & Piano"
                }

                IconButton {
                    mui.icons.material.Menu()
                    onClick = {
                        props.onSideMenuButtonClick()
                    }
                }

                Divider {
                    orientation = Orientation.vertical
                    flexItem = true
                    light = true
                    sx = jso {
                        marginRight = 10.px
                        marginLeft = 10.px
                    }
                }
                Box {
                    sx = jso {
                        flexGrow = FlexGrow(1.0)
                    }
                    Button {
                        sx = jso {
                            marginRight = 7.px
                        }
                        startIcon = LibraryMusic.create()
//                    variant = ButtonVariant.outlined
                        size = Size.medium
                        color = ButtonColor.inherit
                        onClick = {
                            props.onSelectedMainMenuItem("poster")
                        }
                        +"Афиша"
                    }


                    Button {
                        sx = jso {
                            marginRight = 7.px
                        }
                        startIcon = MenuBook.create()
//                    variant = ButtonVariant.outlined
                        size = Size.medium
                        color = ButtonColor.inherit
                        onClick = {
                            props.onSelectedMainMenuItem("menu")
                        }
                        +"Меню"
                    }
                }
//
//                IconButton {
//                    size = Size.large
//                    MenuBook()
//                }

                Box {
                    sx = jso {
                        flexGrow = FlexGrow(0.0)
                    }
                    Tooltip {

                        title = ReactNode("Theme")

                        Switch {
                            icon = Brightness7.create()
                            checkedIcon = Brightness4.create()
                            checked = theme == Themes.Dark
                            ariaLabel = "theme"

                            onChange = { _, checked ->
                                theme = if (checked) Themes.Dark else Themes.Light
                            }
                        }
                    }
                }
            }
        }
    }
}