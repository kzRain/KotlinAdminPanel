package kz.beigam.component.showcase

import csstype.Color
import csstype.ZIndex
import kotlinx.js.jso
import mui.material.Backdrop
import mui.material.Button
import mui.material.CircularProgress
import mui.material.CircularProgressColor
import react.FC
import react.Props
import react.useState

val BackdropShowcase = FC<Props> {
    var isOpen by useState(false)

    Button {
        onClick = { isOpen = !isOpen }

        +"Show backdrop"
    }
    Backdrop {
        open = isOpen
        onClick = { isOpen = false }
        sx = jso {
            color = Color("#FFFFFF")
            zIndex = ZIndex(1000)
        }

        CircularProgress {
            color = CircularProgressColor.inherit
        }
    }
}
