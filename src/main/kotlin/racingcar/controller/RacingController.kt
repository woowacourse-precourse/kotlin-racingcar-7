package racingcar.controller

import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.numbergenerator.NumberGenerator
import racingcar.validator.CarNameValidator
import racingcar.validator.RoundValidator
import racingcar.view.*

private const val ROUND_START = 1
private const val CAR_NAME_DELIMITER = ","

class RacingController(
    private val numberGenerator: NumberGenerator
) {

    fun play() {
        val cars = getCars()
        val rounds = getNumberOfRound()
        val racingCarsStatus = startRace(cars, rounds)
        raceWinnerView(racingCarsStatus)
    }

    private fun getCars(): List<Car> {
        val carNamesInput = carNamesView()
        CarNameValidator.validate(carNamesInput)
        return carNamesInput.split(CAR_NAME_DELIMITER).map { Car(it) }.toList()
    }

    private fun getNumberOfRound(): Int {
        val numberOfRoundInput = numberOfRoundView()
        return RoundValidator.validate(numberOfRoundInput)
    }

    private fun startRace(carNames: List<Car>, lastRound: Int): Cars {
        val racingCars = Cars(carNames)

        printResultComment()
        for (round in ROUND_START..lastRound) {
            racingCars.lap(numberGenerator)
            printRacingStatus(racingCars)
        }

        return racingCars
    }


}