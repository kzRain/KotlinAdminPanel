package kz.beigam.component.showcase

import csstype.px
import kotlinx.js.jso
import mui.material.*
import react.FC
import react.Props
import react.ReactNode
import react.useState

val SelectsShowcase = FC<Props> {
    var age by useState("10")

    Box {
        sx = jso {
            minWidth = 120.px
        }
        FormControl {
            fullWidth = true
            InputLabel {
                id = "demo-simple-select-label"
                +"Age"
            }
            Select {
                labelId = "demo-simple-select-label"
                id = "demo-simple-select"
                // TODO: Needs an ability to set generic type to `Select` component [MUI]
                value = age.unsafeCast<Nothing?>()
                label = ReactNode("Age")
                onChange = {
                    // TODO: It doesn't work even with asDynamic. See console.log [MUI]
                    age = it.asDynamic().target.value
                }
                MenuItem {
                    value = "10"
                    +"Ten"
                }
                MenuItem {
                    value = "20"
                    +"Twenty"
                }
                MenuItem {
                    value = "30"
                    +"Thirty"
                }
            }
        }
    }
}
