package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController {
    private var carState = mutableMapOf<String, Int>()
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        val input = inputView.printInputCarName()
        for (carName in input) {
            carState[carName] = 0
        }

        val raceCount = inputView.printInputRaceCount()

        outputView.printOutputRaceResult()
        repeat(raceCount) {
            race(carState)
            println()
        }

        val winner = getWinner(carState)
        outputView.printOutputWinner(winner)
    }

    private fun race(carState: MutableMap<String, Int>) {
        for (carName in carState.keys) {
            if (checkForward()) {
                carState[carName] = carState.getValue(carName) + 1
            }

            println("$carName : " + "-".repeat(carState.getValue(carName)))
        }
    }

    private fun checkForward(): Boolean {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX) >= RANDOM_NUMBER_CONDITION
    }

    private fun getWinner(carState: MutableMap<String, Int>): List<String> {
        val maxMove = carState.maxOf { it.value }
        return carState.filter { it.value == maxMove }.keys.toList()
    }

    companion object {
        const val RANDOM_NUMBER_MIN = 0
        const val RANDOM_NUMBER_MAX = 9
        const val RANDOM_NUMBER_CONDITION = 4
    }
}