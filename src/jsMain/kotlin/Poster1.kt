//import csstype.*
//import csstype.Cursor.Companion.pointer
//import kotlinx.browser.window
//import kotlinx.js.jso
//import mui.icons.material.Info
//import mui.icons.material.MenuBook
//import mui.material.*
//import react.*
//import react.dom.aria.*
//import react.dom.html.ReactHTML
//import react.dom.html.ReactHTML.div
//import kotlin.math.log
//
//external interface TabPanelProps : PropsWithChildren {
//    var activeValue: Int
//    var index: Int
//}
//
//external interface PosterInfoDialogState {
//    var isOpen: Boolean?
//    var title: String
//    var text: String
//}
//
//
//val TabItem = FC<TabPanelProps> { props ->
//    div {
//        role = AriaRole.tabpanel
//        hidden = props.activeValue != props.index
//        id = "simple-tabpanel-${props.index}"
//        ariaLabelledBy = "simple-tab-${props.index}"
//        Box {
//            Typography {
//                component = ReactHTML.span
//                props.children()
//            }
//        }
//    }
//}
//
////external interface PosterProps : Props {
////    var value: Int
////}
//
//val Poster = FC<Props> {
//    var activeTab by useState(0)
//    var dialogState by useState<PosterInfoDialogState> {
//        object : PosterInfoDialogState {
//            override var isOpen: Boolean? = false
//            override var title: String = ""
//            override var text: String = ""
//
//        }
//    }
//
//
//    Box {
//        sx = jso {
//            width = 100.pct
//        }
//
//        Box {
//            Tabs {
//                variant = TabsVariant.fullWidth
//                value = activeTab
//                onChange = { _, newValue ->
//                    console.log("newValue is $newValue")
//                    activeTab = newValue
//                }
//
//                Tab {
//                    label = ReactNode("Январь")
////                        value = "value1"
//                    id = "simple-tab-0"
//                    ariaControls = "simple-tabpanel-0"
//                }
//                Tab {
//                    label = ReactNode("Февраль")
////                        value = "value 2"
//                    id = "simple-tab-1"
//                    ariaControls = "simple-tabpanel-1"
//                }
//
//            }
//        }
//        TabItem {
//            activeValue = activeTab
//            index = 0
//
//            Box {
//                ImageList {
////                    sx = jso {
////                        width = 500.px
////                        height = 450.px
////                    }
//                    cols = 3
////                    rowHeight = 164
//
//                    for (image in imageSet) {
//                        ImageListItem {
//                            sx = jso {
//                                style = jso {
//                                    cursor = pointer
//                                }
//                            }
//                            onClick = {
//                                dialogState = object : PosterInfoDialogState {
//                                    override var isOpen: Boolean? = true
//                                    override var title: String = image.first
//                                    override var text: String = image.second
//                                }
//                            }
//                            key = image.first
//                            ReactHTML.img {
//                                src = image.second
//                                alt = image.first
//                            }
//                            ImageListItemBar {
//                                position = ImageListItemBarPosition.top
//                                title = ReactNode("Tile ${image.first}")
//                                subtitle = ReactNode("Subtitle ${image.first}")
//                                actionIcon = IconButton.create() {
//                                    sx = jso {
//                                        color = NamedColor.white
//                                        Info()
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    PosterInfoDialog {
//                        isOpen = dialogState.isOpen
//                        title = dialogState.title
//                        text = dialogState.text
//                        onClose = {
//                            dialogState = object : PosterInfoDialogState {
//                                override var isOpen: Boolean? = false
//                                override var title: String = dialogState.title
//                                override var text: String = dialogState.text
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        TabItem {
//            activeValue = activeTab
//            index = 1
//            Button {
//                color = ButtonColor.inherit
//                +"Test2"
//            }
////            IconButton {
////                ariaLabel = "official documentation"
////                ariaHasPopup = AriaHasPopup.`false`
////                size = Size.large
////                color = IconButtonColor.inherit
////                onClick = { window.location.href = "https://mui.com/components/" }
////
////                MenuBook()
////            }
//        }
//    }
//
//}
//
//private val imageSet = listOf(
//    "Немного нервно" to "https://regnum.ru/uploads/pictures/news/2019/08/26/regnum_picture_1566834740338709_normal.jpg",
//    "Канцлер Ги" to "https://newslab.ru/Static/afisha/2019-11-2/Kancler_Gi-237937.jpg",
//    "Карелия" to "https://peterburg2.ru/uploads/21/03/26/o_1_19.jpg",
//    "Princess Angine" to "https://i1.wp.com/www.israelculture.info/wp-content/uploads/2016/03/PA-19.jpg?w=1152&ssl=1",
//)
