import mui.material.*
import mui.system.ResponsiveStyleValue
import react.FC
import react.Props
import react.ReactNode
import react.dom.aria.ariaControls
import react.dom.html.ReactHTML

val Menu = FC<Props> {
    Tabs {
        variant = TabsVariant.fullWidth
        value = 0
        onChange = { _, newValue ->
            console.log("newValue is $newValue")
//            activeTab = newValue
        }

        Tab {
            label = ReactNode("Первые блюда")
                        value = 0
            id = "simple-tab-0"
            ariaControls = "simple-tabpanel-0"
        }
        Tab {
            label = ReactNode("Десерсы")
//                        value = "value1"
            id = "simple-tab-0"
            ariaControls = "simple-tabpanel-0"
        }
    }
    dishes.forEach { dish ->
        Grid {
            container = true
            spacing = ResponsiveStyleValue(2)
            Grid {
                item = true
                xs = 8
                Typography {
//                    sx = jso {
//                        textAlign = TextAlign.center
//                        verticalAlign = VerticalAlign.middle
//                    }
//                    align = TypographyAlign.center
                    variant = "body2"
                    +"Какой-то случайный текст"
                }
            }
            Grid {
                item = true
                xs = 4
                Card {
//                    sx = jso {
//                        maxWidth = 345.px
//                    }

                    CardMedia {
                        component = ReactHTML.img
                        image = dish.second
//                        sx = jso {
//                            height = 140.px
//
//                        }
                    }
                    CardContent {
                        Typography {
                            gutterBottom = true
                            variant = "h5"
                            +dish.first
                        }
                        Typography {
                            variant = "body2"
                            +"Калогии и/или граммы"
                        }
                    }
                }
            }
        }

    }


}

private val dishes = listOf(
    "Цена 1" to "https://media-cdn.tripadvisor.com/media/photo-s/1c/2f/33/2d/healthy-bowl-frische.jpg",
    "Цена 2" to "https://media-cdn.tripadvisor.com/media/photo-s/1c/2f/33/2d/healthy-bowl-frische.jpg",
    "Цена 3" to "https://media-cdn.tripadvisor.com/media/photo-s/1c/2f/33/2d/healthy-bowl-frische.jpg",
)