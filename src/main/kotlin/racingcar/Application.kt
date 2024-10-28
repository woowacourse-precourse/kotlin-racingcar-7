package racingcar

fun main() {
    val gameInitializer = GameInitializer()
    val cars = gameInitializer.cars
    val gameCount = gameInitializer.gameCount

    val game = Game(cars, gameCount)

    game.start()
    game.printWinnerResult()
}
