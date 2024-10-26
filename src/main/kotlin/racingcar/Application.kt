package racingcar

fun main() {
    val names = getCarNames()
    val racingGame = RacingGame(names)
    val tryCount = getTryCount()

    println()
    printResultTitle()
    for (i in 1U..tryCount) {
        racingGame.startOneRound()
        printCarDrivingDistance(racingGame.cars)
    }

    printWinnerName(racingGame.getLeadingCars())
}
