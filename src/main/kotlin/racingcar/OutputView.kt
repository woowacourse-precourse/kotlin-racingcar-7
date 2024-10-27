package racingcar

class OutputView {
    fun showRoundResultTitle() {
        println(Messages.ROUND_RESULT_TITLE)
    }

    fun showCarPosition(car: Car) {
        println(Messages.CAR_POSITION_FORMAT.format(car.name, "-".repeat(car.getCurrentPosition())))
    }

    fun showRoundFooter() {
        println()
    }

    fun showWinners(winners: List<String>) {
        println(Messages.WINNER_ANNOUNCEMENT.format(winners.joinToString(", ")))
    }
}