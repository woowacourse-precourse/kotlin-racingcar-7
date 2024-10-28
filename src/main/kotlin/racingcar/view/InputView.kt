package racingcar.view

import racingcar.validator.InputValidator.validateNameNotNull
import racingcar.validator.InputValidator.validateNameLength
import racingcar.validator.InputValidator.validateNameUniqueness
import racingcar.validator.InputValidator.validateCountIsNumeric
import racingcar.validator.InputValidator.validateCountIsPositive
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun splitNamesByDelimiter(input: String): List<String> {
        return input.split(",")
    }

    fun readCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNames = splitNamesByDelimiter(Console.readLine())
        validateNameNotNull(carNames)
        validateNameLength(carNames)
        validateNameUniqueness(carNames)
        return carNames
    }

    fun readTrialCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine()
        validateCountIsNumeric(input)
        validateCountIsPositive(input)
        return input.toInt()
    }
}
