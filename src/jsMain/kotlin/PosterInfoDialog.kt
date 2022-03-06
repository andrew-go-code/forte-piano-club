import csstype.HtmlAttributes
import mui.material.*
import react.FC
import react.Props
import react.useState

external interface PosterInfoDialogProps : Props {
    var isOpen: Boolean?
    var title: String
    var text: String
    var onClose: () -> Unit
}

val PosterInfoDialog = FC<PosterInfoDialogProps> { props ->
    Dialog {
        fullWidth = true
        open = props.isOpen ?: false

//        fun onCloseButtonClick() {
//            open = false
//        }
        onClose = { _, _ ->
            props.onClose()
        }

        DialogTitle {
            +props.title
        }
        DialogContent {
            DialogContentText {
                +props.text
            }
            DialogActions {
                Button {
                    onClick = {
                        props.onClose()
                    }
                    +"Вернуться"
                }
            }
        }

    }
}