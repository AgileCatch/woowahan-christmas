package christmas.model

import christmas.model.data.MenuItem

object ChristmasMenu {
    val appetizers = listOf(
            MenuItem("양송이수프", 6000),
            MenuItem("타파스", 5500),
            MenuItem("시저샐러드", 8000)
    )

    val mainDishes = listOf(
            MenuItem("티본스테이크", 55000),
            MenuItem("바비큐립", 54000),
            MenuItem("해산물파스타", 35000),
            MenuItem("크리스마스파스타", 25000)
    )

    val desserts = listOf(
            MenuItem("초코케이크", 15000),
            MenuItem("아이스크림", 5000)
    )

    val drinks = listOf(
            MenuItem("제로콜라", 3000),
            MenuItem("레드와인", 60000),
            MenuItem("샴페인", 25000)
    )
}