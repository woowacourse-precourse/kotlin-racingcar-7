package racingcar.infrastructure

import racingcar.domain.Car

class ConsoleOutput : Output
{
    override fun showMessage() {
        println(PLAY_RESULT)
    }

    override fun showRoundResult(cars: List<Car>) {
        var result = ""
        for (car in cars) {
            val carName: String = car.name
            val carDistance: String = ONE_STEP.repeat(car.distance)
            result += "$carName : $carDistance\n"
        }
        println(result)
    }

    override fun showWinners(winners: List<String>) {
        val result = winners.joinToString(DELIMITER)
        println(WINNERS + result)
    }

    companion object {
        private const val ONE_STEP: String = "-"
        private const val DELIMITER: String = ","
        private const val PLAY_RESULT: String = "실행 결과"
        private const val WINNERS: String = "최종 우승자 : "
    }
}