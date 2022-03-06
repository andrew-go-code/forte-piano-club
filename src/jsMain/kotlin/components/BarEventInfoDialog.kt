package components
import mui.material.*
import react.FC
import react.Props

external interface PosterInfoDialogProps : Props {
    var isOpen: Boolean?
    var title: String
    var text: String
    var onClose: () -> Unit
}

val BarInfoInfoDialog = FC<PosterInfoDialogProps> { props ->
    Dialog {
        fullWidth = true
        open = props.isOpen ?: false
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
                    +"Return"
                }
            }
        }
    }
}