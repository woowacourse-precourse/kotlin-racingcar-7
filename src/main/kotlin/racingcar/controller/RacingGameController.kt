package racingcar.controller

import racingcar.view.RacingGameView
import racingcar.model.Car
import racingcar.domain.InputValidator
import racingcar.domain.RacingGameService

class RacingGameController(
    private val racingGameView: RacingGameView,
    private val validator: InputValidator,
    private val racingGameService: RacingGameService
) {
    private var cars: List<Car> = emptyList()
    private var tryCount: Int = 0

    companion object {
        fun create(): RacingGameController {
            val racingGameView = RacingGameView()
            val inputValidator = InputValidator()
            val racingGameService = RacingGameService()
            return RacingGameController(racingGameView, inputValidator, racingGameService)
        }
    }

    fun gameStart() {
        cars = readCarNames()
        tryCount = readTryCount()
        multiRace()
        announceFinalWinner()
    }

    private fun readCarNames(): List<Car> {
        racingGameView.showGameStart()
        val inputString = racingGameView.readLine()
        validator.carNamesValidate(inputString)

        return racingGameService.generateCarsByInput(inputString)
    }

    private fun readTryCount(): Int {
        racingGameView.showInputCount()
        val inputCountString = racingGameView.readLine()
        validator.tryCountValidate(inputCountString)

        return inputCountString.toInt()
    }

    private fun singleRace() {
        cars.forEach {
            racingGameService.moveCarRandomly(it)
            racingGameView.showCarNameWithIndicator(it.name, it.distance)
        }
        racingGameView.showBlankLine()
    }

    private fun multiRace() {
        racingGameView.showBlankLine()
        racingGameView.showRaceResultHeader()
        for (i in 1..tryCount) {
            singleRace()
        }
    }

    private fun announceFinalWinner() {
        val winnersName = racingGameService.findWinnerNames(cars)
        racingGameView.showWinners(winnersName)
    }
}