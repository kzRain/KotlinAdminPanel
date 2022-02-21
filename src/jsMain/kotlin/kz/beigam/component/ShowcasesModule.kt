package kz.beigam.component

import react.FC
import react.PropsWithChildren
import react.createContext
import kz.beigam.entity.Showcases
import kz.beigam.hook.useShowcases

val ShowcasesContext = createContext<Showcases>()

val ShowcasesModule = FC<PropsWithChildren> { props ->
    val users = useShowcases()

    ShowcasesContext.Provider(users) {
        props.children()
    }
}
