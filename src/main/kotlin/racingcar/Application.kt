package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
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
    var splitedCarNames = carNames.split(",")
    return splitedCarNames
}

data class Car(val name: String, val tryCount: Int)