package components
import mui.material.Box
import mui.material.Typography
import react.FC
import react.PropsWithChildren
import react.dom.aria.AriaRole
import react.dom.html.ReactHTML

external interface TabPanelProps : PropsWithChildren {
    var name: String
    var activeValue: Int
    var index: Int
}

val TabPanel = FC<TabPanelProps> { props ->
    ReactHTML.div {
        role = AriaRole.tabpanel
        hidden = props.activeValue != props.index
        id = "tab-panel-${props.name}"
        Box {
            Typography {
                component = ReactHTML.span
                props.children()
            }
        }
    }
}

