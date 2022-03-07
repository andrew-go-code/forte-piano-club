package components
import BarEventsHolder
import csstype.FlexGrow
import csstype.pct
import csstype.px
import getBarEventsHolders
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.js.jso
import mui.material.*
import mui.system.ResponsiveStyleValue
import react.*
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.div

external interface PosterInfoDialogState {
    var isOpen: Boolean?
    var title: String
    var text: String
}

private val scope = MainScope()

val BarEvents = FC<Props> {
    var barEventsHolders by useState(emptyList<BarEventsHolder>())
    var activeTab by useState(0)
    var dialogState by useState<PosterInfoDialogState> {
        object : PosterInfoDialogState {
            override var isOpen: Boolean? = false
            override var title: String = ""
            override var text: String = ""
        }
    }

    useEffectOnce {
        scope.launch {
            barEventsHolders = getBarEventsHolders()
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
                barEventsHolders.forEach {
                    Tab {
                        label = ReactNode("${it.year} ${it.month}")
                        id = "bar-events-tab-${it.id}"
                    }
                }
            }
        }
        barEventsHolders.forEachIndexed { idx, eventHolder ->
            TabPanel {
                name = "tabpanel-bar-events-${eventHolder.id}"
                activeValue = activeTab
                index = idx

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
                                                    height = 240.px
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
