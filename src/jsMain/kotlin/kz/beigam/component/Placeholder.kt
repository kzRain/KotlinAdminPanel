package kz.beigam.component

import ShoppingListItem
import csstype.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.js.jso
import kz.beigam.api.*
import mui.material.Box
import mui.material.Typography
import react.*
import react.css.css
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.img
import react.dom.html.ReactHTML.ul

private val scope = MainScope()

val Placeholder = FC<Props> {
    var shoppingList by useState(emptyList<ShoppingListItem>())

    useEffectOnce {
        scope.launch {
            shoppingList = getShoppingList()
        }
    }

    ul {
        shoppingList.sortedByDescending(ShoppingListItem::priority).forEach { item ->
            ReactHTML.li {
                key = item.toString()
                onClick = {
                    scope.launch {
                        deleteShoppingListItem(item)
                        shoppingList = getShoppingList()
                    }
                }
                +"[${item.priority}] ${item.desc} "
            }
        }
    }

    InputComponent {
        onSubmit = { input ->
            val cartItem = ShoppingListItem(input.replace("!", ""), input.count { it == '!' })
            scope.launch {
                addShoppingListItem(cartItem)
                shoppingList = getShoppingList()
            }
        }
    }

    Box {
        sx = jso {
            display = Display.grid
            justifyContent = JustifyContent.center
            gridTemplateRows = array(0.fr, 0.fr)
        }


        Typography {
            variant = "h6"

            +"To start the showcase please select a component"
        }

        img {
            css {
                width = 450.px
                transform = scale(1, -1)
            }

            src = "arrow.png"
        }
    }
}
