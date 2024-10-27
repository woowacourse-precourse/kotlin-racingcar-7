package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.Strings.ERROR_INVALID_TRY_COUNT
import racingcar.Strings.INPUT_CAR_NAMES
import racingcar.Strings.INPUT_TRY_COUNT

class InputView {
    private val validator = Validator()

    fun getCarNames(): List<String> {
        println(INPUT_CAR_NAMES)
        val input = Console.readLine()

        val carNames = input.split(",").map { it.trim() }
        validator.validateNameLength(carNames)
        validator.validateNameDuplication(carNames)

        return carNames
    }

    fun getTryCount(): Int {
        println(INPUT_TRY_COUNT)

        return runCatching {
            val tryCount = Console.readLine().toInt()
            validator.validateTryCount(tryCount)
            tryCount
        }.getOrElse {
            throw IllegalArgumentException(ERROR_INVALID_TRY_COUNT)
        }
    }
}