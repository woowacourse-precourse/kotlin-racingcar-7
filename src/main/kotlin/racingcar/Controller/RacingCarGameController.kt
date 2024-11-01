package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingCarGameController {
    private var racingCars: MutableList<RacingCar> = mutableListOf()
    private var tryCount = 0
    private val racingCarGameView = RacingCarGameView(racingCars)

    companion object {
        private const val MAX_CARNAME_LENGTH = 5
        private const val CARNAME_TOO_LONG = "자동차 이름은 5자를 넘을 수 없습니다."
        private const val CARNAME_DUPLICATE = "자동차 이름은 중복될 수 없습니다."
        private const val TRYCOUNT_NOT_POSITVIE_INTEGER_OR_ZERO = "시도 횟수는 양의 정수나 0이어야 합니다."
    }

    fun play() {
        getCarNamesAndTryCount()
        playAllTurns()
        racingCarGameView.printWinner()
    }

    private fun getCarNamesAndTryCount() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val inputCarNames = Console.readLine()
        val carNames = inputCarNames.split(",")
        checkIfValidNames(carNames)
        getTryCountInput()
        makeRacingCars(carNames)
    }

    private fun checkIfValidNames(carNames: List<String>) {
        if (carNames.any { it.length > MAX_CARNAME_LENGTH })
            throw IllegalArgumentException(CARNAME_TOO_LONG)
        val nameCounts = carNames.groupingBy { it }.eachCount()
        if (nameCounts.maxOf { it.value } > 1)
            throw IllegalArgumentException(CARNAME_DUPLICATE)
        return
    }

    private fun makeRacingCars(carNames: List<String>) {
        carNames.forEach {
            racingCars.add(RacingCar(it))
        }
    }

    private fun getTryCountInput() {
        println("시도할 횟수는 몇 회인가요?")
        val inputTryCount = Console.readLine()
        checkIfValidCount(inputTryCount)
        tryCount = inputTryCount.toInt()
    }

    private fun checkIfValidCount(tryCount: String) {
        if (tryCount.all { it.isDigit() }) {
            return
        }
        throw IllegalArgumentException(TRYCOUNT_NOT_POSITVIE_INTEGER_OR_ZERO)
    }

    private fun playAllTurns() {
        println("\n실행결과")
        for (turn in 1..tryCount) {
            racingCars.forEach {
                it.takeTurn()
            }
            racingCarGameView.printTurnResult()
        }
    }
}