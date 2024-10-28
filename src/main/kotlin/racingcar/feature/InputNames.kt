package racingcar.feature

import camp.nextstep.edu.missionutils.Console
import racingcar.utils.isNamesInvalid

class InputNames {

    var names: String = ""

    fun printInputNamesMessage() {
        println(INPUT_NAMES_MESSAGE)
    }

    fun readNames() {
        names = Console.readLine()
    }

    fun validateNames() {
        if (names.isNamesInvalid()) {
            throw IllegalArgumentException()
        }
    }

    companion object {
        private const val INPUT_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    }
}