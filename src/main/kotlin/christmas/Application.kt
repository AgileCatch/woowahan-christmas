package christmas

import christmas.controller.EventPlannerController
import christmas.model.ChristmasMenu
import christmas.view.InputView
import christmas.view.OutputView

fun main() {
    val menu = ChristmasMenu
    val inputView = InputView(menu)
    val outputView = OutputView(menu)
    val controller = EventPlannerController(inputView, outputView, menu)
    controller.run()
}
