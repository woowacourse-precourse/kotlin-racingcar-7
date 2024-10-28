package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Computer {

    fun inputCarName(): String {
        printInputCarNameMessage()
        return Console.readLine()
    }

    fun inputRoundCount(): String {
        printInputRoundCountMessage()
        return Console.readLine()
    }

    fun generate() = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)

    fun printCarPosition(car: Car) {
        println(car.getStatus())
    }

    fun printWinner(cars: List<Car>) {
        println(makeWinnerMessage(cars))
    }

    fun makeWinnerMessage(cars: List<Car>): String {
        val winnerFrontMessage = WINNER_FRONT_MESSAGE
        val winner = mutableListOf<String>()
        cars.forEach {
            winner.add(it.name)
        }
        return winnerFrontMessage + winner.joinToString(COMMA_AND_BLANK)
    }

    private fun printInputCarNameMessage() {
        println(INPUT_CAR_NAME_MESSAGE)
    }

    private fun printInputRoundCountMessage() {
        println(INPUT_ROUND_COUNT_MESSAGE)
    }
}