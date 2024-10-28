package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(val inputNumber: String) {
    var number = 0
    fun NumericCheck() {
        if (inputNumber.all { it.isDigit() }) {
            number = inputNumber.toInt()
        } else throw IllegalArgumentException("[ERROR] 숫자를 입력하세요.")
    }

    fun MinCheck() {
        if (number < 1) {
            throw IllegalArgumentException("[ERROR] 최소 1 이상의 숫자를 입력하세요.")
        }
    }

    fun validateNumber() {
        NumericCheck()
        MinCheck()
    }
}