package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.exception.InvalidDateException


class InputView {
    fun readDate(){
        while (true) {
            try {
                //선택한 값 예외처리 클래스로 보내 검사하기
                val input = Console.readLine()
                InvalidDateException.validateDateInput(input) ?: continue//올바른 값이 입력될때까지 계속 반복
                break//올바른 값이 입력되면 멈춤
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }


}