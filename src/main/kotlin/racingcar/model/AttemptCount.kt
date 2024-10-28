package racingcar.model

import racingcar.util.Validator

class AttemptCount(private val input: String) {
    val count: Int = input.toInt()

    init {
        Validator.validateAttempt(input)
    }
}
