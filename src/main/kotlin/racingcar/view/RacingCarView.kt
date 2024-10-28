package racingcar.view

import camp.nextstep.edu.missionutils.Console

class RacingCarView {

    private val getCarNameStr = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private val getAttemptsStr = "시도할 횟수는 몇 회인가요?"
    private val showResults = "최종 우승자 :"
    private val naturalNumException = "횟수는 자연수 숫자를 입력해야 합니다"
    fun getCarName(): String {
        println(getCarNameStr)
        return Console.readLine()
    }

    fun getAttempts(): Int {
        println(getAttemptsStr)
        return isNaturalNumber(Console.readLine())
    }

    fun displayAttemptResult(resultAttempts: String) {
        print(resultAttempts)
    }

    fun displayResult(result: String) {
        print("$showResults $result")
    }

    //Exception
    private fun isNaturalNumber(it: String): Int{
        return it.toIntOrNull() ?: throw IllegalArgumentException("$naturalNumException: $it")
    }

}