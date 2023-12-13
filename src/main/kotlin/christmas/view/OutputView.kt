package christmas.view

import christmas.model.ChristmasMenu
import christmas.model.data.MenuItem

class OutputView(private val menu: ChristmasMenu) {

    fun printWelcome() {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n" +
                "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
    }

    fun printMenu() {
        println("<애피타이저>")
        printItems(menu.appetizers)

        println("\n<메인>")
        printItems(menu.mainDishes)

        println("\n<디저트>")
        printItems(menu.desserts)

        println("\n<음료>")
        printItems(menu.drinks)
    }

    private fun printItems(items: List<MenuItem>) {
        items.joinToString { "${it.name}(${printPriceFormat(it.price)})" }.let { println(it) }
    }

    private fun printPriceFormat(price: Int): String {
        val formatter = java.text.NumberFormat.getInstance(java.util.Locale.US)
        return formatter.format(price)
    }


}