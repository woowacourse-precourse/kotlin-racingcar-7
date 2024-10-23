package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingCarGameController {
    private var racingCars: MutableList<RacingCar> = mutableListOf()
    private var tryCount = 0
    private val racingCarGameView = RacingCarGameView(racingCars)

    fun play() {
        getCarNamesAndTryCounts()
        playAllTurns()
        racingCarGameView.printTotalResult()
    }

    private fun getCarNamesAndTryCounts() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val userInput = Console.readLine()
        val carNames = userInput.split(",")
        checkIfValidNames(carNames)
        getTryCountsInput()
        makeRacingCar(carNames)
    }

    private fun checkIfValidNames(carNames: List<String>) {
        if (carNames.all{it.length <= 5})
            return
        throw IllegalArgumentException()
    }

    private fun makeRacingCar(carNames: List<String>) {
        carNames.forEach {
            racingCars.add(RacingCar(it))
        }
    }

    private fun getTryCountsInput() {
        println("시도할 횟수는 몇 회인가요?")
        val tryCountInput = Console.readLine()
        checkIfValidCount(tryCountInput)
        tryCount = tryCountInput.toInt()
    }

    private fun checkIfValidCount(tryCount: String) {
        if (tryCount.all{it.isDigit()}) {
            return
        }
        throw IllegalArgumentException()
    }

    private fun playAllTurns() {
        for (turn in 1..tryCount) {
            racingCars.forEach {
                it.takeTurn()
            }
            racingCarGameView.printTurnResult()
        }
    }
}