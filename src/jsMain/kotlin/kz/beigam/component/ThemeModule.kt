package kz.beigam.component

import mui.material.CssBaseline
import mui.material.styles.Theme
import mui.material.styles.ThemeProvider
import react.*
import kz.beigam.common.Themes

typealias ThemeState = StateInstance<Theme>

val ThemeContext = createContext<ThemeState>()

val ThemeModule = FC<PropsWithChildren> { props ->
    val state = useState(Themes.Light)
    val (theme) = state

    ThemeContext.Provider(state) {
        ThemeProvider {
            this.theme = theme

            CssBaseline()
            props.children()
        }
    }
}
