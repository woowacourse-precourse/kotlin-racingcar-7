package racingcar.domain

import racingcar.view.OutputView

class RacingGame(
    private val carNames: List<String>,
    private val gameRound: Int
) {
    private var racingCars: List<RacingCar>? = null

    init {
        setRacingCars()
    }

    private fun setRacingCars() {
        racingCars = carNames.map { RacingCar(it) }
    }

    fun play() {
        OutputView.printExecutionResult()
        for (i in 1..gameRound) {
            playRound()
        }
        OutputView.printWinners(getWinners())
    }

    private fun playRound() {
        racingCars?.forEach { it.play() }
        printRoundResult()
    }

    private fun printRoundResult() {
        racingCars?.forEach { it.printCarPosition() }
        println()
    }

    private fun getWinners(): List<String> {
        val maxPosition = racingCars?.maxOf { it.position }
        return racingCars?.filter { it.position == maxPosition }?.map { it.name } ?: emptyList()
    }
}