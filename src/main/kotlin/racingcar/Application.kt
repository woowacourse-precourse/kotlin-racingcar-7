package racingcar

fun main() {
    val racingCarSetup = RacingCarSetup()
    val cars = racingCarSetup.cars
    val tryCount = racingCarSetup.tryCount
    val racingCarGame = RacingCarGame(cars, tryCount)
    racingCarGame.start()
    racingCarGame.printWinnerResult()
}
