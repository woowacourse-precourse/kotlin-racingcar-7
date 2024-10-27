package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.Messages.ERROR_DUPLICATE_NAME
import racingcar.Messages.ERROR_INVALID_TRY_COUNT
import racingcar.Messages.ERROR_NAME_LENGTH
import racingcar.Messages.INPUT_CAR_NAMES
import racingcar.Messages.INPUT_TRY_COUNT

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

    fun getTryCount(): Int {
        println(INPUT_TRY_COUNT)
        val input = Console.readLine()

        return try {
            val tryCount = input.toInt()
            validateTryCount(tryCount)
            tryCount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_INVALID_TRY_COUNT)
        }
    }

    private fun validateTryCount(tryCount: Int) {
        if (tryCount <= 0) {
            throw IllegalArgumentException(ERROR_INVALID_TRY_COUNT)
        }
    }
}