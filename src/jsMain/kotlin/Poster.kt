import csstype.*
import csstype.Cursor.Companion.pointer
import kotlinx.browser.window
import kotlinx.js.jso
import mui.icons.material.Info
import mui.icons.material.MenuBook
import mui.material.*
import mui.material.Size
import mui.system.ResponsiveStyleValue
import react.*
import react.dom.aria.*
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.col
import react.dom.html.ReactHTML.div
import kotlin.math.log

external interface TabPanelProps : PropsWithChildren {
    var activeValue: Int
    var index: Int
}

external interface PosterInfoDialogState {
    var isOpen: Boolean?
    var title: String
    var text: String
}


val TabItem = FC<TabPanelProps> { props ->
    div {
        role = AriaRole.tabpanel
        hidden = props.activeValue != props.index
        id = "simple-tabpanel-${props.index}"
        ariaLabelledBy = "simple-tab-${props.index}"
        Box {
            Typography {
                component = ReactHTML.span
                props.children()
            }
        }
    }
}

//external interface PosterProps : Props {
//    var value: Int
//}

val Poster = FC<Props> {
    var activeTab by useState(0)
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
                    console.log("newValue is $newValue")
                    activeTab = newValue
                }

                Tab {
                    label = ReactNode("Январь")
//                        value = "value1"
                    id = "simple-tab-0"
                    ariaControls = "simple-tabpanel-0"
                }
                Tab {
                    label = ReactNode("Февраль")
//                        value = "value 2"
                    id = "simple-tab-1"
                    ariaControls = "simple-tabpanel-1"
                }

            }
        }
        TabItem {
            activeValue = activeTab
            index = 0

            Box {
                sx = jso {
                    flexGrow = FlexGrow(1.0)
                }

                Grid {
                    container = true
                    spacing = ResponsiveStyleValue(2)
//                    columns = ResponsiveStyleValue(4)
                    for (img in imageSet) {
                        Grid {
                            item = true
                            xs = 4
                            Box {
                                Card {
                                    sx = jso {
                                    width = 320.px
                                        height = 415.px
                                    }
                                    CardActionArea {
                                        CardMedia {
                                            component = ReactHTML.img
                                            image = img.second
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
                                                component = ReactHTML.div
                                                +img.first
                                            }
                                            Typography {
                                                variant = "body2"
                                                sx = jso {
                                                    asDynamic().color = "text.secondary"
                                                }
                                                +("Lizards are a widespread group of squamate reptiles, with over 6,000 " +
                                                        "species, ranging across all continents except Antarctica")
                                            }
                                        }
                                    }
                                    CardActions {
                                        Button {
                                            size = Size.small
                                            color = ButtonColor.primary
                                            +"Купить билет"
                                        }
                                    }

                                }
                            }
                        }
                    }

                }
            }
        }
        PosterInfoDialog {
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
    TabItem {
        activeValue = activeTab
        index = 1
        Button {
            color = ButtonColor.inherit
            +"Test2"
        }
//            IconButton {
//                ariaLabel = "official documentation"
//                ariaHasPopup = AriaHasPopup.`false`
//                size = Size.large
//                color = IconButtonColor.inherit
//                onClick = { window.location.href = "https://mui.com/components/" }
//
//                MenuBook()
//            }
    }
}


private val imageSet = listOf(
    "Немного нервно" to "https://regnum.ru/uploads/pictures/news/2019/08/26/regnum_picture_1566834740338709_normal.jpg",
    "Канцлер Ги" to "https://newslab.ru/Static/afisha/2019-11-2/Kancler_Gi-237937.jpg",
    "Карелия" to "https://peterburg2.ru/uploads/21/03/26/o_1_19.jpg",
    "Princess Angine" to "https://i1.wp.com/www.israelculture.info/wp-content/uploads/2016/03/PA-19.jpg?w=1152&ssl=1",
    "Немного нервно" to "https://regnum.ru/uploads/pictures/news/2019/08/26/regnum_picture_1566834740338709_normal.jpg",
    "Канцлер Ги" to "https://newslab.ru/Static/afisha/2019-11-2/Kancler_Gi-237937.jpg",
    "Карелия" to "https://peterburg2.ru/uploads/21/03/26/o_1_19.jpg",
    "Princess Angine" to "https://i1.wp.com/www.israelculture.info/wp-content/uploads/2016/03/PA-19.jpg?w=1152&ssl=1",
)
