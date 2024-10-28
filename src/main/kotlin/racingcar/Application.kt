package racingcar

fun main() {
    val racingCarSetup = Setup()
    val cars = racingCarSetup.cars
    val tryCount = racingCarSetup.tryCount
    val racingCarGame = Game(cars, tryCount)
    racingCarGame.start()
    racingCarGame.printWinnerResult()
}
