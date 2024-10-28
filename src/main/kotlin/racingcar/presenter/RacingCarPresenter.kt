package racingcar.presenter

import racingcar.model.Car
import racingcar.model.RacingCar
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

        val roundNumber = roundString.toInt()

        validateCarsNames(carNames)
        validateRoundType(roundString)
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