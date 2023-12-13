package christmas

import christmas.controller.EventPlannerController
import christmas.view.InputView
import christmas.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val controller = EventPlannerController(inputView, outputView)
    controller.run()
}
