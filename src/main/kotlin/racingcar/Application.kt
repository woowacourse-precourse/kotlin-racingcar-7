package racingcar

fun main() {
    val names = getCarNames()
    val racingGame = RacingGame(names)
    val tryCount = getTryCount()

    println()
    printResultTitle()
    for (i in 1..tryCount) {
        racingGame.startOneRound()
        printCarDrivingDistance(racingGame.cars)
    }

    printWinnerName(racingGame.getLeadingCars())
}
