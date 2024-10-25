package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.Output.Companion.RACE_START

class Race {
    private val moveProgress = mutableMapOf<String, String>()
    private val maxDistance by lazy { moveProgress.values.max() }
    private val winnerList = mutableListOf<String>()
    private val output: Output = Output()

    fun start(carNames: List<String>, moveCount: Int) {
        
        initMap(carNames)
        output.raceStart()
        repeat(moveCount) { iterateEachCar() }

        for ((carName, moveDistance) in moveProgress) {
            selectWinnerMatch(moveDistance, carName)
        }

        output.winnerAnnounce(winnerList)
    }

    private fun initMap(carNames: List<String>) = carNames.forEach { carName -> moveProgress.put(carName, BLANK) }

    private fun iterateEachCar() {
        for (carName in moveProgress.keys) {
            moveProgress[carName] += moveOrStop()

            output.flowOfRace(carName, moveProgress)
        }
        output.newLine()
    }

    private fun selectWinnerMatch(moveDistance: String, carName: String) {
        if (moveDistance == maxDistance) {
            winnerList.add(carName)
        }
    }

    private fun randomValue(): Int = Randoms.pickNumberInRange(0, 9)

    private fun moveOrStop(): String {
        if (randomValue() >= 4) return MOVE else return STOP
    }

    private companion object {
        const val MOVE = "-"
        const val STOP = ""
        const val BLANK = ""
    }
}