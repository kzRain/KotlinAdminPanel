package kz.beigam.component

import csstype.Color
import csstype.GridArea
import csstype.None.none
import kotlinx.js.jso
import mui.material.*
import mui.system.Box
import react.FC
import react.Props
import react.ReactNode
import react.css.css
import react.dom.html.ReactHTML
import react.router.dom.NavLink
import react.router.useLocation
import react.useContext
import kz.beigam.common.GridAreas
import kz.beigam.common.Sizes

val Sidebar = FC<Props> {
    val showcases = useContext(ShowcasesContext)
    val lastPathname = useLocation().pathname.substringAfterLast("/")

    Box {
        component = ReactHTML.nav
        sx = jso {
            gridArea = GridArea(GridAreas.Sidebar)
        }

        Drawer {
            variant = DrawerVariant.permanent
            anchor = DrawerAnchor.left

            Toolbar()

            List {
                sx = jso { width = Sizes.Sidebar.Width }

                for ((key, name) in showcases) {
                    NavLink {
                        to = key

                        css {
                            textDecoration = none
                            color = Color.currentcolor
                        }

                        ListItemButton {
                            selected = lastPathname == key

                            ListItemText {
                                primary = ReactNode(name)
                            }
                        }
                    }
                }
            }
        }
    }
}
