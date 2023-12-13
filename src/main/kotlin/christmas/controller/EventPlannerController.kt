package christmas.controller

import christmas.view.InputView
import christmas.view.OutputView

class EventPlannerController(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        outputView.printWelcome()

        val selectedDate = inputView.readDate()


    }
}