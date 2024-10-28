package racingcar

class Driver {
    val reader = Reader()

    fun getValidDriver(): List<String> {
        return checkCarNameException(inputCarName())
    }

    private fun inputCarName(): List<String> {
        return reader.inputNum().split(",")
    }

    private fun checkCarNameException(carName: List<String>): List<String> {
        if (carName.any { it.isBlank() }) {
            throw IllegalArgumentException(ERROR_CAR_NAME_EMPTY)
        }
        for (carList in carName) {
            if (carList.length !in 0..5) {
                throw IllegalArgumentException(ERROR_CAR_NAME_LENGTH)
            }
        }
        return carName
    }

    companion object {
        const val ERROR_CAR_NAME_EMPTY = "입력된 자동차 이름에 빈 값이 포함될 수 없습니다."
        const val ERROR_CAR_NAME_LENGTH = "자동차의 이름이 5자 이하가 아닙니다."
    }

}