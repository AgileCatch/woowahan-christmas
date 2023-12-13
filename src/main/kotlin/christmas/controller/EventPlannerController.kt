package christmas.controller

import christmas.model.ChristmasMenu
import christmas.view.InputView
import christmas.view.OutputView

class EventPlannerController(private val inputView: InputView, private val outputView: OutputView, private val menu: ChristmasMenu) {
    fun run() {
        outputView.printWelcome()

        val selectedDate = inputView.readDate()
        outputView.printSelectedDate(selectedDate)
        outputView.printMenu()
        outputView.printOrderMenu()

        val selectedMenu = inputView.readOrderMenu()
        outputView.printSelectedMenu(selectedMenu)

    }
}