package kz.beigam.component

import csstype.FlexGrow
import csstype.GridArea
import csstype.ZIndex
import kotlinx.browser.window
import kotlinx.js.jso
import mui.icons.material.Brightness4
import mui.icons.material.Brightness7
import mui.icons.material.GitHub
import mui.icons.material.MenuBook
import mui.material.*
import react.*
import react.dom.aria.AriaHasPopup.`false`
import react.dom.aria.ariaHasPopup
import react.dom.aria.ariaLabel
import react.dom.html.ReactHTML
import react.router.useLocation
import kz.beigam.common.GridAreas
import kz.beigam.common.Themes

val Header = FC<Props> {
    var theme by useContext(ThemeContext)
    val lastPathname = useLocation().pathname.substringAfterLast("/")

    AppBar {
        position = AppBarPosition.fixed
        sx = jso {
            gridArea = GridArea(GridAreas.Header)
            zIndex = ZIndex(1_500)
        }

        Toolbar {
            Typography {
                sx = jso { flexGrow = FlexGrow(1.0) }
                variant = "h6"
                noWrap = true
                component = ReactHTML.div

                +"Kotlin MUI Showcase"
            }

            Tooltip {
                title = ReactNode("Theme")

                Switch {
                    icon = Brightness7.create()
                    checkedIcon = Brightness4.create()
                    checked = theme == Themes.Dark
                    ariaLabel = "theme"

                    onChange = { _, checked ->
                        theme = if (checked) Themes.Dark else Themes.Light
                    }
                }
            }

            Tooltip {
                title = ReactNode("Read Documentation")

                IconButton {
                    ariaLabel = "official documentation"
                    ariaHasPopup = `false`
                    size = Size.large
                    color = IconButtonColor.inherit
                    onClick = { window.location.href = "https://mui.com/components/$lastPathname" }

                    MenuBook()
                }
            }

            Tooltip {
                title = ReactNode("View Sources")

                IconButton {
                    ariaLabel = "source code"
                    ariaHasPopup = `false`
                    size = Size.large
                    color = IconButtonColor.inherit
                    onClick = {
                        var name = lastPathname
                            .split("-")
                            .asSequence()
                            .map { it.replaceFirstChar { it.titlecase() } }
                            .reduce { accumulator, word -> accumulator.plus(word) }

                        if (name.isNotEmpty()) {
                            name += ".kt"
                        }

                        window.location.href =
                            "https://github.com/karakum-team/kotlin-mui-showcase/blob/main/src/main/kotlin/team/karakum/component/showcase/$name"
                    }

                    GitHub()
                }
            }
        }
    }
}
