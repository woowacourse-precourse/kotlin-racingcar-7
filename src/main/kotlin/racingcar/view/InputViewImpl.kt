package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.utils.Validator

class InputViewImpl : InputView {

    override fun readNames(): List<String> {
        println(NAME_PROMPT)
        val input = Console.readLine()
        Validator.validateName(input)
        return input.split(DEFAULT_DELIMITER)
    }

    override fun readAttemptCount(): Int {
        println(ATTEMPT_COUNT_PROMPT)
        val input = Console.readLine()
        Validator.validateAttemptCount(input)
        return input.toInt()
    }

    companion object {
        private const val NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val ATTEMPT_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?"
        private const val DEFAULT_DELIMITER = ","
    }
}