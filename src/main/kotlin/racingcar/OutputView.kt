package racingcar

import racingcar.Strings.ROUND_RESULT_TITLE
import racingcar.Strings.CAR_POSITION_FORMAT
import racingcar.Strings.WINNER_ANNOUNCEMENT

class OutputView {
    fun showRoundResultTitle() {
        println(ROUND_RESULT_TITLE)
    }

    fun showCarPosition(car: Car) {
        println(CAR_POSITION_FORMAT.format(car.name, "-".repeat(car.getCurrentPosition())))
    }

    fun showRoundFooter() {
        println()
    }

    fun showWinners(winners: List<String>) {
        println(WINNER_ANNOUNCEMENT.format(winners.joinToString(", ")))
    }
}