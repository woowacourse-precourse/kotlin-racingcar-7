package racingcar

fun main() {
    val names = readCarNames()
    val tryNumber = readTryNumber()

    println("실행 결과")

    race(names, tryNumber)

    winner(names, tryNumber)
}