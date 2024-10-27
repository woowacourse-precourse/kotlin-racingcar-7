package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(private val randomProvider: () -> Int = ::generateRandomNumber) {
    private var carState = mutableMapOf<String, Int>()
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        val input = inputView.printInputCarName()

        initCarState(input)

        val raceCount = inputView.printInputRaceCount()

        outputView.printOutputRaceResult()
        repeat(raceCount) {
            race(carState)
            println()
        }

        val winner = getWinner(carState)
        outputView.printOutputWinner(winner)
    }

    fun initCarState(input: List<String>): MutableMap<String, Int> {
        for (carName in input) {
            carState[carName] = 0
        }
        return carState
    }

    private fun race(carState: MutableMap<String, Int>) {
        updateCarStates(carState)
        printCarStates(carState)
    }

    private fun checkForward(): Boolean {
        return randomProvider() >= RANDOM_NUMBER_CONDITION
    }

    fun updateCarStates(carState: MutableMap<String, Int>) {
        for (carName in carState.keys) {
            if (checkForward()) {
                carState[carName] = carState.getValue(carName) + 1
            }
        }
    }

    fun printCarStates(carState: MutableMap<String, Int>) {
        for (carName in carState.keys) {
            println("$carName : " + "-".repeat(carState.getValue(carName)))
        }
    }

    fun getWinner(carState: MutableMap<String, Int>): List<String> {
        val maxMove = carState.maxOf { it.value }
        return carState.filter { it.value == maxMove }.keys.toList()
    }

    companion object {
        const val RANDOM_NUMBER_MIN = 0
        const val RANDOM_NUMBER_MAX = 9
        const val RANDOM_NUMBER_CONDITION = 4

        private fun generateRandomNumber(): Int {
            return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX)
        }
    }
}