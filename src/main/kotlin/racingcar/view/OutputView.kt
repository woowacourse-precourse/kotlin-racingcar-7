package racingcar.view

import racingcar.constant.ViewConstants

class OutputView {
    fun showResultMessage() {
        println(ViewConstants.RESULT_MESSAGE)
    }

    fun showRoundResult(carName: String, location: String) {
        println("$carName : $location")
    }

    fun roundSeparator() {
        println()
    }

    fun showWinners(winners: String) {
        println("${ViewConstants.WINNER_MESSAGE}$winners")
    }
}