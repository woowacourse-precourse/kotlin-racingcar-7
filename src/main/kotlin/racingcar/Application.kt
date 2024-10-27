package racingcar

import racingcar.controller.RacingGameController

fun main() {
    val racingGame = RacingGameController.create()
    racingGame.gameStart()
}
