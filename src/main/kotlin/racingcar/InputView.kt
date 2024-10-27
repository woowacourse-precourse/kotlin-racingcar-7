package racingcar

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getCarNames(): List<String> {
        println(INPUT_CAR_NAMES)
        val input = Console.readLine()

        val carNames = input.split(",").map { it.trim() }
        validateCarNames(carNames)

        return carNames
    }

    private fun validateCarNames(carNames: List<String>) {
        if (carNames.any { it.isEmpty() || it.length > 5 }) {
            throw IllegalArgumentException(ERROR_NAME_LENGTH)
        }
        if (carNames.size != carNames.distinct().size) {
            throw IllegalArgumentException(ERROR_DUPLICATE_NAME)
        }
    }

    companion object{
        const val INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val ERROR_NAME_LENGTH = "자동차 이름은 1자 이상 5자 이하의 이름이어야 합니다."
        const val ERROR_DUPLICATE_NAME = "자동차 이름은 중복될 수 없습니다."
    }
}