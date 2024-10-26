package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.controller.InputValidator

class InputView {

    fun printInputCarName(): List<String> {
        println(INPUT_CAR_NAME_MESSAGE)

        val input = Console.readLine().split(",")
        InputValidator.validateCarName(input)

        return input
    }

    fun printInputRaceCount(): Int {
        println(INPUT_RACE_COUNT_MESSAGE)

        val raceCount = Console.readLine()
        InputValidator.validateRaceCount(raceCount)

        return raceCount.toInt()
    }

    companion object {
        const val INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val INPUT_RACE_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}