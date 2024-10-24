package racingcar.controller

import camp.nextstep.edu.missionutils.Console

class RacingController {

    fun start() {
        printInputCarName()
        val input = Console.readLine().split(",")

    }

    private fun printInputCarName() = println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
}