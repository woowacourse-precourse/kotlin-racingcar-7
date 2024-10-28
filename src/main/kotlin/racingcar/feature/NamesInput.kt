package racingcar.feature

import camp.nextstep.edu.missionutils.Console
import racingcar.utils.isNamesInvalid

class NamesInput {

    fun printInputNames() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun inputNames(): String {
        return Console.readLine()
    }

    fun checkNamesInput(namesInput: String): Boolean {
        return if (namesInput.isNamesInvalid()) {
            throw IllegalArgumentException()
        } else {
            true
        }
    }
}