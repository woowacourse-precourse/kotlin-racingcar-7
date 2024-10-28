package racingcar

import racingcar.view.InputView

fun main() {
    val inputView = InputView()
    val carNames = inputView.readCarNames()
    inputView.readTrialCount()
}
