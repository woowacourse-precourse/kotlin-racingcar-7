package racingcar

object GameManager {
    private val validation = Validation()
    private lateinit var carNames: List<String>
    private var attemptTimes: Int = 0
    private lateinit var round: Round

    fun generateCars(input: String) {
        validation.validateInputHasComma(input)
        carNames = validation.validateCarNames(input.split(",").map { it.trim() })
        initializeRound()
    }

    private fun initializeRound() {
        round = Round(carNames)
    }

    fun setAttemptTimes(input: String) {
        attemptTimes = validation.getAttemptTimes(input)
    }

    fun getRound(): Round {
        return round
    }

    fun playRound() {
        repeat(attemptTimes) {
            playOneRound()
        }
    }

    private fun playOneRound() {
        round.start()
        round.printRound()
    }

    fun getWinners(): List<String> {
        return round.getWinners()
    }

}