package racingcar

import java.awt.SystemColor.text

class RacingGame(val inputnumber: String) {
    var number = 0
    fun NumericCheck() {
        if (inputnumber.all { it.isDigit() }) {
            number = inputnumber.toInt()
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