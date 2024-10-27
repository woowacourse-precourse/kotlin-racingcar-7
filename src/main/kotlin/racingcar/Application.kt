package racingcar

import racingcar.controller.RaceGameController
import racingcar.service.RaceGameService
import racingcar.strategy.RandomMoveStrategy
import racingcar.view.RaceGameView

fun main() {
    val raceGameView = RaceGameView()
    val raceGameService = RaceGameService(RandomMoveStrategy())
    val raceGameController = RaceGameController(raceGameView, raceGameService)
    raceGameController.startRaceProcess()
}
