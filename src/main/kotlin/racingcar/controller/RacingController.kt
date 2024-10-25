package racingcar.controller

import racingcar.domain.car.Cars
import racingcar.domain.numbergenerator.NumberGenerator
import racingcar.validator.CarNameValidator
import racingcar.validator.RoundValidator
import racingcar.view.*

class RacingController(
    private val numberGenerator: NumberGenerator
) {

    fun play() {
        val carNames = getCarNames()
        val rounds = getNumberOfRound()
        val racingCarsStatus = startRace(carNames, rounds)
        raceWinnerView(racingCarsStatus)
    }

    private fun getCarNames(): String {
        val carNamesInput = carNamesView()
        return CarNameValidator.validate(carNamesInput)
    }

    private fun getNumberOfRound(): Int {
        val numberOfRoundInput = numberOfRoundView()
        return RoundValidator.validate(numberOfRoundInput)
    }

    private fun startRace(carNames: String, rounds: Int): Cars {
        val racingCars = Cars(carNames)

        printResultComment()
        for (round in 1..rounds) {
            racingCars.lap(numberGenerator)
            printRacingStatus(racingCars)
        }

        return racingCars
    }

}