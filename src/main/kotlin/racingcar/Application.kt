package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val cars = carNameInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carList = splitCarName(cars)
    val tryCount = tryCountInput("시도할 횟수는 몇 회인가요?").toInt()
    val tryCountList = initTryCountList(tryCount)
}
fun carNameInput(prompt: String): String{
    println(prompt)
    return readLine()
}

fun tryCountInput(promt: String): String{
    println(promt)
    return readLine()
}

fun splitCarName(carNames: String): List<String>{
    val splitedCarNames = carNames.split(",")
    return splitedCarNames
}

fun initTryCountList(tryCount: Int): MutableList<Int>{
    val tryCountList = MutableList(tryCount) { 0 }
    return tryCountList
}