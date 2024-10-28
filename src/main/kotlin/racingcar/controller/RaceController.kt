package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car
import racingcar.model.Race
import racingcar.utils.Constants
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController {
    fun startRace() {
        try {
            val carNames = InputView.getCarNames().map { it.trim() }
            val cars = carNames.map { Car(it) }

            val numberOfRounds = InputView.getNumberOfRounds()
            val race = Race(cars, numberOfRounds)

            repeat(numberOfRounds) {
                race.raceRound { Randoms.pickNumberInRange(Constants.RANDOM_MIN, Constants.RANDOM_MAX) }
                OutputView.printRoundResult(cars)
            }

            val winners = race.findWinners()
            OutputView.printWinners(winners)
        }catch (e: IllegalArgumentException) {
            e.message?.let { OutputView.printErrorMessage(it) }
            throw e
        }

    }
}
