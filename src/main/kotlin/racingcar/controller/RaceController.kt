package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car
import racingcar.model.Race
import racingcar.utils.Constants
import racingcar.utils.Validator
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController {
    fun startRace() {
        try {
            val carNames = InputView.getCarNames().map { it.trim() }
            val cars = carNames.map { Car(it) }

            val race = Race(cars)
            val roundsInput = InputView.getNumberOfRounds()
            val numberOfRounds = Validator.validateRounds(roundsInput)

            OutputView.printResult()
            playRounds(race, cars, numberOfRounds)

            val winners = race.findWinners()
            OutputView.printWinners(winners)
        } catch (e: IllegalArgumentException) {
            e.message?.let { OutputView.printErrorMessage(it) }
            throw e
        }
    }
    private fun playRounds(race: Race, cars: List<Car>, numberOfRounds: Int) {
        repeat(numberOfRounds) {
            race.raceRound { Randoms.pickNumberInRange(Constants.RANDOM_MIN, Constants.RANDOM_MAX) }
            OutputView.printRoundResult(cars)
        }
    }
}
