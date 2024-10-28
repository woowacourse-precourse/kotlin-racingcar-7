package racingcar

fun main() {
    val initializer = Initializer()
    val cars = initializer.cars
    val gameCount = initializer.gameCount

    val game = Game(cars, gameCount)

    game.start()
    game.printWinnerResult()
}
