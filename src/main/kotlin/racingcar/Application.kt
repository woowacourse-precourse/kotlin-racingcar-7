package racingcar

import racingcar.controller.RacingGameController
import racingcar.view.RacingGameView

fun main() {
    val racingGameView = RacingGameView()
    val racingGameController = RacingGameController(racingGameView)
    racingGameController.gameStart()
}
