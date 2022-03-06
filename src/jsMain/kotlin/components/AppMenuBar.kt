package components
import csstype.FlexGrow
import csstype.px
import kotlinx.js.jso
import mui.icons.material.Brightness4
import mui.icons.material.Brightness7
import mui.material.*
import react.*
import react.dom.aria.ariaLabel
import react.dom.html.ReactHTML

external interface MainMenuProps : Props {
    var onSideMenuButtonClick: () -> Unit
}

val AppMenuBar = FC<MainMenuProps> { props ->
    var theme by useContext(ThemeContext)

    Box {
        AppBar {
            position = AppBarPosition.static
            Toolbar {
                Typography {
                    sx = jso {
                        marginRight = 2.px
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
                }
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