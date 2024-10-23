package racingcar

fun main() {
    val outputView = OutputView()
    val racingGame = RacingGame(outputView)
    racingGame.gameStart()
}
