package racingcar

fun main() {
    val names = readCarNames()
    val tryNumber = readTryNumber()

    println("실행 결과")

    winner(names, tryNumber.toInt())
}