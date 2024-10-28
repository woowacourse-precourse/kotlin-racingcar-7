package racingcar

import racingcar.domain.Car
import racingcar.domain.Racing
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGame(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun startGame() {
        val inputNames = inputView.readCarNames()
        inputView.validateCarNames(inputNames)

        val inputCount = inputView.readTryCount()
        inputView.validateTryCount(inputCount.toInt())

        val cars = inputNames.map { Car(it) }
        val racing = Racing(cars)

        println("\n실행 결과")
        repeat(inputCount.toInt()){
            racing.race()
            racing.getStatus().forEach(::println)
            println()
        }
        outputView.printWinner(racing.getWinner())
    }
}