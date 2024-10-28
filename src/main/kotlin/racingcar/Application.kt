package racingcar

import racingcar.controller.RaceController
import racingcar.view.Input
import racingcar.view.Output

fun main() {
    val input = Input()
    val output = Output()

    val raceController = RaceController(input.getCarNames(), input.getRaceRound(), output)
    raceController.start()
}