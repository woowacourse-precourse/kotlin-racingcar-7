package racingcar

import camp.nextstep.edu.missionutils.Console

class Driver {
    lateinit var carList: List<String>

    fun inputCarName(): List<String> {
        val carName = Console.readLine().split(",")
        return checkCarNameException(carName)
    }

    private fun checkCarNameException(carName: List<String>): List<String> {
        if (carName.any { it.isBlank() }) {
            throw IllegalArgumentException(ERROR_CAR_NAME_EMPTY)
        }
        for (carName in carList) {
            if (carName.length !in 0..5) {
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