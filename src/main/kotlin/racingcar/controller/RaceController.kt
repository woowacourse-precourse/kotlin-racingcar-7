package racingcar.controller

import racingcar.model.Race
import racingcar.util.InputValidator
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
    private val validator: InputValidator = InputValidator(),
) {
    private lateinit var race: Race

    fun run() {
        setUp()
        showRoundResult()
        showWinnerResult()

        inputView.close()
    }

    private fun setUp() {
        val carNamesInput = inputView.getCarNames()
        val roundsInput = inputView.getRounds()

        val carList = validator.getValidCarList(carNamesInput)
        val rounds = validator.getValidRounds(roundsInput)

        race = Race(carList, rounds)
    }

    private fun showRoundResult() {
        race.play { carList ->
            outputView.printRoundResult(carList)
        }
    }

    private fun showWinnerResult() {
        val raceWinner = race.getRaceWinner()
        outputView.printWinner(raceWinner)
    }
}