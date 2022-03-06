package components
import csstype.FlexGrow
import csstype.pct
import csstype.px
import kotlinx.js.jso
import mui.material.*
import mui.system.ResponsiveStyleValue
import react.FC
import react.Props
import react.ReactNode
import react.dom.html.ReactHTML
import react.useState

val BarMenu = FC<Props> {
    var activeTab by useState(1)

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
                barMenuHolder.forEach {
                    Tab {
                        label = ReactNode(it.category)
                        id = "bar-menu-tab-${it.id}"
                        value = it.id
                    }
                }
            }
        }
    }


    barMenuHolder.forEach { menuHolder ->
        TabPanel {
            name = "tabpanel-bar-menu-${menuHolder.id}"
            activeValue = activeTab
            id = menuHolder.id

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
                                CardMedia {
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

private data class BarMenuHolder(
    val id: Int,
    val category: String,
    val items: List<BarMenuItem>
) {
    data class BarMenuItem(
        val id: Int,
        val name: String,
        val description: String,
        val calories: Int,
        val imageSrc: String,
        val price: Int
    )
}

private val barMenuHolder = listOf(
    BarMenuHolder(
        id = 1,
        category = "Drinks",
        items = listOf(
            BarMenuHolder.BarMenuItem(
                id = 1,
                name = "name 1",
                description = "description 1",
                calories = 100,
                imageSrc = "https://media-cdn.tripadvisor.com/media/photo-s/1c/2f/33/2d/healthy-bowl-frische.jpg",
                price = 100
            ),
            BarMenuHolder.BarMenuItem(
                id = 2,
                name = "name 2",
                description = "description 2",
                calories = 100,
                imageSrc = "https://media-cdn.tripadvisor.com/media/photo-s/1c/2f/33/2d/healthy-bowl-frische.jpg",
                price = 200
            ),
        )
    ),
    BarMenuHolder(
        id = 2,
        category = "Dessert",
        items = listOf(
            BarMenuHolder.BarMenuItem(
                id = 3,
                name = "name 3",
                description = "description 3",
                calories = 100,
                imageSrc = "https://media-cdn.tripadvisor.com/media/photo-s/1c/2f/33/2d/healthy-bowl-frische.jpg",
                price = 300
            ),
            BarMenuHolder.BarMenuItem(
                id = 4,
                name = "name 4",
                description = "description 4",
                calories = 100,
                imageSrc = "https://media-cdn.tripadvisor.com/media/photo-s/1c/2f/33/2d/healthy-bowl-frische.jpg",
                price = 400
            ),
        )
    )
)