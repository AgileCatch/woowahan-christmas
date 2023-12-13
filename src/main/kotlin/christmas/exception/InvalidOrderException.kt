package christmas.exception

import christmas.model.ChristmasMenu
import christmas.model.data.MenuItem
import christmas.model.data.OrderItem

object InvalidOrderException {
    fun validateOrderInput(inputMenu: String?, menu: ChristmasMenu): List<OrderItem>? {
        if (inputMenu.isNullOrBlank()) {
            throwIllegalArgumentException()
            return null
        }
        if (inputMenu.contains("-")){
            throwIllegalArgumentException()
            return null
        }
        val orders = inputMenu.split(",").map { orderString ->
            val (menuName, quantity) = orderString.split("-")
            val name = findMenuItem(menu, menuName.trim())
            when {
                //메뉴갯수를 정수로 변환할수 있는지
                quantity.toIntOrNull() == null -> {
                    throwIllegalArgumentException()
                    return null
                }

                //메뉴이름 잘못 입력시 null 반환
                name == null -> {
                    throwIllegalArgumentException()
                    return null
                }

            }
            val menuItem = name.toString()
            OrderItem(menuItem, quantity.trim().toInt())
        }

        when {
            orders.map { it.menuName }.toSet().size != orders.size -> validateDuplicateMenu()
            orders.any { it.quantity <= 0 } -> throwIllegalArgumentException()
            orders.sumOf { it.quantity } > 20 -> throwIllegalArgumentException()
        }

        return orders
    }

    private fun findMenuItem(menu: ChristmasMenu, menuName: String): MenuItem? {
        return menu.appetizers.find { it.name == menuName }
                ?: menu.mainDishes.find { it.name == menuName }
                ?: menu.desserts.find { it.name == menuName }
                ?: menu.drinks.find { it.name == menuName }
    }

    private fun throwIllegalArgumentException() {
        throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
    }

    private fun validateDuplicateMenu() {
        throw IllegalArgumentException("[ERROR] 중복된 메뉴가 있습니다. 다시 입력해 주세요.")
    }
}
