package racingcar

import racingcar.utils.InputUtils

fun main() {
    // TODO: 프로그램 구현
    val carList = InputUtils.getCarList()
    val totalRound = InputUtils.getTotalRound()

    RacingGame(carList = carList, totalRound = totalRound).play()
}


