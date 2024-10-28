package racingcar

import racingcar.utils.InputUtils
import racingcar.utils.PrintResultUtils

fun main() {
    // TODO: 프로그램 구현
    val carList = InputUtils.getCarList()
    val totalRound = InputUtils.getTotalRound()
    val game = RacingGame(carList = carList, totalRound = totalRound)
    game.play()
    PrintResultUtils.printResult(scoreMap = game.scoreMap, winners = game.getWinners())
}


