package racingcar

import racingcar.controller.RacingGameController
import racingcar.domain.InputValidator
import racingcar.domain.RacingGameService
import racingcar.view.RacingGameView

fun main() {
    val racingGameView = RacingGameView()
    val inputValidator = InputValidator()
    val racingGameService = RacingGameService()
    val racingGameController = RacingGameController(racingGameView, inputValidator, racingGameService)
    racingGameController.gameStart()
}
