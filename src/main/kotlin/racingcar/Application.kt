package racingcar

import racingcar.controller.RacingGameController
import racingcar.validator.InputValidator
import racingcar.view.RacingGameView

fun main() {
    val racingGameView = RacingGameView()
    val inputValidator = InputValidator()
    val racingGameController = RacingGameController(racingGameView, inputValidator)
    racingGameController.gameStart()
}
