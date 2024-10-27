package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    fun splitNamesByDelimiter(input: String): List<String> {
        return input.split(",")
    }

    fun readCarNames() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = splitNamesByDelimiter(Console.readLine())
    }


    fun readTrialCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return Console.readLine().toInt()
    }

    println(readCarNames())
    println(readTrialCount())
}
