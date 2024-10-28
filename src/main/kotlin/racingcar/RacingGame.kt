package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class RacingGame {

    private val checkInput = CheckInput()

    fun initGame() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val cars = Console.readLine()

        val finalCarList = checkInput.checkParticipant(cars)

        println("시도할 횟수는 몇 회인가요?")
        val numOfGame = Console.readLine()

        val trial = checkInput.checkTrial(numOfGame)

        startGame(finalCarList, trial)
    }

    fun startGame(carList: List<String>, numOfGame: Int) {

        val carPositions = carList.associateWith { 0 }.toMutableMap()

        println("실행 결과")

        for (step in 0 .. numOfGame) {
            for (currentCar in carList) {
                randomGameResult(carPositions, currentCar)
            }
            println()
        }

        printWinner(carPositions)
    }

    fun randomGameResult(carPositions: MutableMap<String, Int>, currentCar: String) {
        if(Randoms.pickNumberInRange(0, 9) >= 4) {
            // 전진
            carPositions[currentCar] = carPositions[currentCar]!! + 1
        }
        println("${currentCar} : ${carPositions[currentCar]?.let { "-".repeat(it) }}")
    }

    fun printWinner(carPositions: MutableMap<String, Int>) {

        val winnerList = checkWinner(carPositions)

        println("최종 우승자 : ${winnerList.joinToString(",")}")
    }

    fun checkWinner(carPositions: MutableMap<String, Int>): MutableList<String> {
        val winnerDistance = carPositions.values.maxOrNull()

        val winnerList = mutableListOf<String>()
        for((carName,distance) in carPositions) {
            if(distance == winnerDistance) {
                winnerList.add(carName)
            }
        }

        return winnerList
    }
}