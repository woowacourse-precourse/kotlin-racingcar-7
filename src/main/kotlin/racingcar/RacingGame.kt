package racingcar

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms

class RacingGame(
    private val outputView: OutputView
) {
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
        outputView.printGameStart()
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
        outputView.printInputCount()
        val inputCountString = readLine()
        return inputCountString.toInt()
    }

    /**
     * 경주를 한번 진행 하고 결과를 출력
     */
    private fun singleRace() {
        cars.forEach {
            val randomVal = Randoms.pickNumberInRange(0, 9)
            if (randomVal >= 4) {
                it.moveForward()
            }
            outputView.printCarNameWithIndicator(it, true)
        }
    }

    /**
     * 경주를 시도횟수 만큼 진행 하고 결과를 출력
     */
    private fun multiRace() {
        outputView.printRaceResult(true)
        for (i in 1..tryCount) {
            singleRace()
        }
    }

    /**
     * 최종 우승자 출력
     */
    private fun printFinalWinner() {
        val winnerDistance = cars.maxOf { it.distance }
        val winners = cars.filter { it.distance == winnerDistance }
        val winnersName = winners.map { it.name }
        outputView.printWinners(winnersName)
    }
}