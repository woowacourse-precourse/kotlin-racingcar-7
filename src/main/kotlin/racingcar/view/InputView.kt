package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputCarNames(): String {
        printInputCarNamesMessage()
        val carNames = readLine()
        return carNames
    }

    private fun readLine() = Console.readLine()

    private fun printInputCarNamesMessage() = println(INPUT_CAR_NAME_MESSAGE)

    companion object {
        private const val INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    }
}
