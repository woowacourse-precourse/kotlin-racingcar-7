package racingcar.view

import racingcar.model.Car

class OutputView {
    fun printRoundResult(carList: List<Car>) {
        val sb = StringBuilder()
        carList.forEach { car ->
            sb.appendLine(car.formatRoundResult())
        }
        println(sb)
    }

    fun printWinner(carNames: List<String>) {
        val winnerList = carNames.joinToString(", ")
        print(WINNER_MSG_FORMAT.format(winnerList))
    }

    private fun Car.formatRoundResult() = "$name : ${"-".repeat(moves)}"

    companion object {
        private const val WINNER_MSG_FORMAT = "최종 우승자 : %s"
    }
}