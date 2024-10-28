package racingcar

import racingcar.utils.InputUtils
import racingcar.utils.ResultPrintUtils

fun main() {
    val carList = InputUtils.getCarList()
    val totalRound = InputUtils.getTotalRound()
    val game = RacingGame(carList = carList, totalRound = totalRound)
    game.play()
    ResultPrintUtils.printResult(scoreMap = game.scoreMap, winners = game.getWinners())
}


