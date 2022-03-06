package components
import csstype.FlexGrow
import csstype.pct
import csstype.px
import kotlinx.browser.window
import kotlinx.js.jso
import mui.material.*
import mui.system.ResponsiveStyleValue
import react.FC
import react.Props
import react.ReactNode
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.div
import react.useState

external interface PosterInfoDialogState {
    var isOpen: Boolean?
    var title: String
    var text: String
}

val BarEvents = FC<Props> {
    var activeTab by useState(1)
    var dialogState by useState<PosterInfoDialogState> {
        object : PosterInfoDialogState {
            override var isOpen: Boolean? = false
            override var title: String = ""
            override var text: String = ""
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
                barEventsHolder.forEach {
                    Tab {
                        label = ReactNode("${it.year} ${it.month}")
                        id = "bar-events-tab-${it.id}"
                        value = it.id
                    }
                }
            }
        }
        barEventsHolder.forEach { eventHolder ->
            TabPanel {
                name = "tabpanel-bar-events-${eventHolder.id}"
                activeValue = activeTab
                id = eventHolder.id

                Box {
                    sx = jso {
                        flexGrow = FlexGrow(1.0)
                    }

                    Grid {
                        container = true
                        spacing = ResponsiveStyleValue(2)

                        eventHolder.events.forEach { event ->
                            Grid {
                                item = true
                                xs = 4
                                Box {
                                    Card {
                                        sx = jso {
                                            width = 320.px
                                            height = 400.px
                                        }
                                        CardActionArea {
                                            asDynamic().onClick = {
                                                dialogState = object : PosterInfoDialogState {
                                                    override var isOpen: Boolean? = true
                                                    override var title: String = event.name
                                                    override var text: String = event.details
                                                }
                                            }
                                            CardMedia {
                                                component = ReactHTML.img
                                                image = event.imageSrc
                                                sx = jso {
//                                                asDynamic().height = "auto"
                                                    height = 240.px
//                                                asDynamic().width = "auto"
//                                                maxWidth = 250.px
                                                }
                                            }
                                            CardContent {
                                                Typography {
                                                    gutterBottom = true
                                                    variant = "h5"
                                                    component = div
                                                    +event.name
                                                }
                                                Typography {
                                                    variant = "body2"
                                                    sx = jso {
                                                        asDynamic().color = "text.secondary"
                                                    }
                                                    +event.genre
                                                }
                                            }
                                        }
                                        CardActions {
                                            Button {
                                                size = Size.small
                                                color = ButtonColor.primary
                                                onClick = {
                                                    window.alert("Not implemented")
                                                }
                                                +"Buy"
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


        BarInfoInfoDialog {
            isOpen = dialogState.isOpen
            title = dialogState.title
            text = dialogState.text
            onClose = {
                dialogState = object : PosterInfoDialogState {
                    override var isOpen: Boolean? = false
                    override var title: String = dialogState.title
                    override var text: String = dialogState.text
                }
            }
        }
    }
}

private data class BarEventsHolder(
    val id: Int,
    val year: Int,
    val month: String,
    val events: List<BarEvent>
    ) {
    data class BarEvent(
        val id: Int,
        val name: String,
        val genre: String,
        val details: String,
        val imageSrc: String
    )
}

private val barEventsHolder = listOf(
    BarEventsHolder(
        id = 1,
        year = 2022,
        month = "January",
        events = listOf(
            BarEventsHolder.BarEvent(
                id = 1,
                name = "Немного нервно",
                genre = "Dream folk",
                details = "Dream folk",
                imageSrc = "https://regnum.ru/uploads/pictures/news/2019/08/26/regnum_picture_1566834740338709_normal.jpg"
            ),
            BarEventsHolder.BarEvent(
                id = 2,
                name = "Канцлер Ги",
                genre = "Rock",
                details = "Rock",
                imageSrc = "https://newslab.ru/Static/afisha/2019-11-2/Kancler_Gi-237937.jpg"
            ),
            BarEventsHolder.BarEvent(
                id = 3,
                name = "Карелия",
                genre = "Folk",
                details = "Folk",
                imageSrc = "https://peterburg2.ru/uploads/21/03/26/o_1_19.jpg"
            ),
            BarEventsHolder.BarEvent(
                id = 4,
                name = "Princess Angine",
                genre = "Indi",
                details = "Indi",
                imageSrc = "https://i1.wp.com/www.israelculture.info/wp-content/uploads/2016/03/PA-19.jpg?w=1152&ssl=1"
            )
        )
    ),
    BarEventsHolder(
        id = 2,
        year = 2022,
        month = "February",
        events = listOf(
            BarEventsHolder.BarEvent(
                id = 5,
                name = "Немного нервно",
                genre = "Dream Folk",
                details = "Dream folk",
                imageSrc = "https://regnum.ru/uploads/pictures/news/2019/08/26/regnum_picture_1566834740338709_normal.jpg"
            )
        )
    )
)
