package racingcar

import racingcar.view.CommandLineView
import racingcar.view.View

fun main() {
    Application().run()
}

class Application(private val view: View = CommandLineView()) {
    fun run() {
        view.requestCarNames()
        view.requestRoundCount()
        view.showMatchProcess()
        view.showWinner()
    }
}