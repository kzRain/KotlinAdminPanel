package kz.beigam.component.showcase

import csstype.pct
import csstype.px
import kotlinx.js.jso
import mui.icons.material.Star
import mui.material.*
import react.FC
import react.Props

val ListsShowcase = FC<Props> {
    List {
        sx = jso {
            width = 100.pct
            maxWidth = 360.px
        }

        ListItem {
            disablePadding = true

            ListItemButton {
                ListItemIcon {
                    Star()
                }
                ListItemText {
                    +"Chelsea Otakan"
                }
            }
        }
        ListItem {
            disablePadding = true

            ListItemButton {
                ListItemText {
                    +"Eric Hoffman"
                }
            }
        }
    }
}
