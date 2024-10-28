package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car
import racingcar.model.Race
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController {
    fun startRace() {
        val carNames = InputView.getCarNames().map { it.trim() }.filter { it.length <= 5 }
        val numberOfRounds = InputView.getNumberOfRounds()

        val cars = carNames.map { Car(it) }
        val race = Race(cars, numberOfRounds)

        repeat(numberOfRounds) {
            race.raceRound { Randoms.pickNumberInRange(0, 9) }
            OutputView.printRoundResult(cars)
        }

        val winners = race.findWinners()
        OutputView.printWinners(winners)
    }
}
