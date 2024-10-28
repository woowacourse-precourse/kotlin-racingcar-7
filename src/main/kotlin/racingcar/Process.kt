package racingcar

import racingcar.Validation
object Process {
    private val validation = Validation()
    private lateinit var carNames: List<String>
    private var attemptTimes: Int = 0
    private lateinit var round: Round

    fun generateCars(input: String) {
        carNames = validation.validateCarNames(input.split(",").map { it.trim() })
        round = Round()
    }

    fun setAttemptTimes(input: String) {
        attemptTimes = validation.getAttemptTimes(input)
    }

    fun getRound(): Round {
        return round
    }


}