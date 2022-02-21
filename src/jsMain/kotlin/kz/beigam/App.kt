package kz.beigam

import csstype.Auto.auto
import csstype.Display
import csstype.GridArea
import csstype.GridTemplateAreas
import csstype.array
import kotlinx.browser.document
import kotlinx.js.jso
import mui.system.Box
import react.FC
import react.Props
import react.create
import react.dom.render
import react.router.dom.HashRouter
import kz.beigam.common.GridAreas
import kz.beigam.common.Sizes.Header
import kz.beigam.common.Sizes.Sidebar
import kz.beigam.component.*

fun main() {
    render(
        element = App.create(),
        container = document.createElement("div").also { document.body!!.appendChild(it) },
    )
}

private val App = FC<Props> {
    HashRouter {
        ShowcasesModule {
            ThemeModule {
                Box {
                    sx = jso {
                        display = Display.grid
                        gridTemplateRows = array(
                            Header.Height,
                            auto,
                        )
                        gridTemplateColumns = array(
                            Sidebar.Width, auto,
                        )
                        gridTemplateAreas = GridTemplateAreas(
                            GridArea("${GridAreas.Header} ${GridAreas.Header}"),
                            GridArea("${GridAreas.Sidebar} ${GridAreas.Content}"),
                        )
                    }

                    Header()
                    Sidebar()
                    Content()
                }
            }
        }
    }
}
