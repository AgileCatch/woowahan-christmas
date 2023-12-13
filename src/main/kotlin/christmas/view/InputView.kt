package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.exception.InvalidDateException
import christmas.exception.InvalidOrderException
import christmas.model.ChristmasMenu
import christmas.model.data.OrderItem


class InputView(private val menu: ChristmasMenu) {
    fun readDate(): Int {
        var selectedDate: Int
        while (true) {
            try {
                //선택한 값 예외처리 클래스로 보내 검사하기
                val inputDate = Console.readLine()
                selectedDate = InvalidDateException.validateDateInput(inputDate) ?: continue//올바른 값이 입력될때까지 계속 반복
                break//올바른 값이 입력되면 멈춤
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        return selectedDate
    }

    fun readOrderMenu(): List<OrderItem> {
        var selectedMenu: List<OrderItem>
        while (true) {
            try {
                val inputMenu = Console.readLine()
                selectedMenu = InvalidOrderException.validateOrderInput(inputMenu, menu) ?: continue
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        return selectedMenu
    }
}