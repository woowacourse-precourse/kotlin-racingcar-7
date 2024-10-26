package racingcar

class RacingGameController {
    private val racingGame = RacingGame()

    fun run() {
        val input = InputView.inputNames()
        val round = InputView.inputRound()

        OutputView.printProcess()
        val result = racingGame.start(input, round)
        OutputView.printResult(result)
    }
}
