package racingcar.presenter

import racingcar.model.Car
import racingcar.model.RacingCar
import racingcar.util.ValidatorUtil
import racingcar.util.ValidatorUtil.validateCarLength
import racingcar.util.ValidatorUtil.validateCarName
import racingcar.util.ValidatorUtil.validateCarsNames
import racingcar.util.ValidatorUtil.validateRoundRange
import racingcar.util.ValidatorUtil.validateRoundType
import racingcar.view.RacingCarView

class RacingCarPresenter(
    private val racingCarView: RacingCarView
) {
    fun startRacingCar(
        carNames: List<String>,
        roundString: String
    ) {

        validateCarsNames(carNames)
        carNames.forEach { name ->
            validateCarLength(name.length)
            validateCarName(name)
        }

        validateRoundType(roundString)
        val roundNumber = roundString.toInt()
        validateRoundRange(roundNumber)

        val cars = carNames.map { Car(it) }
        val racingCar = RacingCar(cars)

        repeat(roundNumber) {
            racingCar.playRound()
            racingCarView.displayRaceRound(cars)
        }

        val winners = racingCar.findWinners()
        racingCarView.displayWinners(winners)

    }
}