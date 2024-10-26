package racingcar.controller

import camp.nextstep.edu.missionutils.Console
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
        for (car in carState.keys) {
            if (checkForward()) {
                // !!써서 carState[car]!! + 1  or  carState[car]!!.plus(1) 쓸지 얘로 쓸지 고민..
                carState[car] = carState.getValue(car) + 1
            }

            println("$car : " + "-".repeat(carState.getValue(car)))
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