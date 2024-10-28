package racingcar

import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    RacingGame(InputView(), OutputView()).startGame()
}
