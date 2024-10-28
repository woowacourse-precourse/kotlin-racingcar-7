package racingcar

fun main() {
    val carNames = inputCarNames()
    validateCarNames(carNames)
    val attemptCount = inputAttemptCount()
    val distances = raceCars(carNames, attemptCount)
    val winners = determineWinners(carNames, distances)
    println("최종 우승자 : ${winners.joinToString(", ")}")
}
