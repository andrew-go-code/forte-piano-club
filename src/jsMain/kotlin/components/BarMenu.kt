package components
import BarMenuHolder
import csstype.FlexGrow
import csstype.pct
import csstype.px
import getBarMenuHolders
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.js.jso
import mui.material.*
import mui.system.ResponsiveStyleValue
import react.*
import react.dom.html.ReactHTML

private val scope = MainScope()

val BarMenu = FC<Props> {
    var barMenuHolders by useState(emptyList<BarMenuHolder>())
    var activeTab by useState(0)

    useEffectOnce {
        scope.launch {
            barMenuHolders = getBarMenuHolders()
        }
    }

    Box {
        sx = jso {
            width = 100.pct
        }

        Box {
            Tabs {
                variant = TabsVariant.fullWidth
                value = activeTab
                onChange = { _, newValue ->
                    activeTab = newValue
                }
                barMenuHolders.forEach {
                    Tab {
                        label = ReactNode(it.category)
                        id = "bar-menu-tab-${it.id}"
                    }
                }
            }
        }
    }

    barMenuHolders.forEachIndexed { idx, menuHolder ->
        TabPanel {
            name = "tabpanel-bar-menu-${menuHolder.id}"
            activeValue = activeTab
            index = idx

            Box {
                sx = jso {
                    flexGrow = FlexGrow(1.0)
                }

                Grid {
                    container = true
                    spacing = ResponsiveStyleValue(2)

                    menuHolder.items.forEach { menuItem ->
                        Grid {
                            item = true
                            xs = 8

                            Typography {
                                variant = "body1"
                                +menuItem.name
                            }
                            Divider {
                                light = true
                                sx = jso {
                                    marginTop = 10.px
                                    marginBottom = 10.px
                                }
                            }
                            Typography {
                                variant = "body2"
                                +menuItem.description
                            }
                        }
                        Grid {
                            item = true
                            xs = 4
                            Card {
//                                sx = jso {
//                                    width = 400.px
//                                    height = 400.px
//                                }

                                CardMedia {
                                    sx = jso {
                                        height = 240.px
                                    }
                                    component = ReactHTML.img
                                    image = menuItem.imageSrc
                                }
                                CardContent {
                                    Typography {
                                        gutterBottom = true
                                        variant = "h5"
                                        +(menuItem.price.toString() + " $")
                                    }

                                    Typography {
                                        variant = "body2"
                                        +"Calories: ${menuItem.calories}"
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}