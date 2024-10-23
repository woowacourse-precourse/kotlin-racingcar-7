package racingcar

import racingcar.resources.Messages
import camp.nextstep.edu.missionutils.Console.readLine

class RacingGame {
    private var cars: List<Car> = emptyList()
    private var tryCount: Int = 0

    fun gameStart() {
        cars = readCarNames()
        tryCount = inputTryCount()
        multiRace()
        printFinalWinner()
    }

    /**
     * 자동차 이름들을 사용자로부터 입력받기
     * @return 자동차 이름들과 0으로 초기화된 LinkedHashMap 값
     */
    private fun readCarNames(): List<Car> {
        println(Messages.GAME_START)
        val inputString = readLine()

        return splitCarNames(inputString)
    }

    private fun splitCarNames(input: String): List<Car> {
        val names = input.split(",")

        return names.map { Car(it) }
    }

    /**
     * 자동차 경주 횟수를 사용자로 부터 입력받기
     * @return 자동차 경주 횟수를 나타내는 Int 값
     */
    fun inputTryCount(): Int {
        println(Messages.GAME_INPUT_COUNT)
        val inputCountString = readLine()
        return inputCountString.toInt()
    }

    /**
     * 경주를 한번 진행 하고 결과를 출력
     */
    private fun singleRace() {
        cars.forEach {
            it.randomMove()
            println(it.getNameWithIndicator())
        }
    }

    /**
     * 경주를 시도횟수 만큼 진행 하고 결과를 출력
     */
    private fun multiRace() {
        println()
        println(Messages.GAME_RESULT)
        for (i in 1..tryCount) {
            singleRace()
            println()
        }
    }

    /**
     * 최종 우승자 출력
     */
    private fun printFinalWinner() {
        val winnerDistance = cars.maxOf { it.distance }
        val winners = cars.filter { it.distance == winnerDistance }
        val winnersName = winners.map { it.name }
        println(Messages.GAME_WINNER.format(winnersName.joinToString(", ")))
    }
}