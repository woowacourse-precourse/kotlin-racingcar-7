package racingcar.view

import racingcar.model.Car

class OutputView {
    fun showStatus(status: List<String>) {
        status.forEach { println(it) }
        println()
    }

    fun showWinners(result: String) {
        print(result)
    }
}