package christmas.exception

object InputException {
    fun validateDateInput(input: String?): Int? {
        when {
            input == null || input.toIntOrNull() == null || input.toInt() !in 1..31 -> {
                throwIllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
            }
        }
        return input?.toInt()
    }

    private fun throwIllegalArgumentException(message: String) {
        throw IllegalArgumentException(message)
    }

}
