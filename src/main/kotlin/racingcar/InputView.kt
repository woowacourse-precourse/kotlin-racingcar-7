package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.Messages.ERROR_INVALID_TRY_COUNT
import racingcar.Messages.INPUT_CAR_NAMES
import racingcar.Messages.INPUT_TRY_COUNT

class InputView {
    private val validator = Validator()

    fun getCarNames(): List<String> {
        println(INPUT_CAR_NAMES)
        val input = Console.readLine()

        val carNames = input.split(",").map { it.trim() }
        validator.validateCarNames(carNames)

        return carNames
    }

    fun getTryCount(): Int {
        println(INPUT_TRY_COUNT)
        val input = Console.readLine()

        return try {
            val tryCount = input.toInt()
            validator.validateTryCount(tryCount)
            tryCount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_INVALID_TRY_COUNT)
        }
    }
}