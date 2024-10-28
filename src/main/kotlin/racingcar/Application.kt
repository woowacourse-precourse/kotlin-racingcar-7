package racingcar

fun main() {
    val names = readCarNames()
    val tryNumber = readTryNumber()
    val finalParticipants = divideNames(names)

    println("실행 결과")

    val position = race(finalParticipants, tryNumber)
    val winners = findWinners(position)
    println("최종 우승자 : ${winners.joinToString(", ")}")
}