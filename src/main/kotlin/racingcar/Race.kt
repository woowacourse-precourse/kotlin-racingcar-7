package racingcar

import camp.nextstep.edu.missionutils.Randoms
import javax.swing.JToolBar.Separator

class Race {
    private val moveProgress = mutableMapOf<String, String>()
    private val maxDistance by lazy { moveProgress.values.max() }
    private val winnerList = mutableListOf<String>()

    fun start(carNames: List<String>, moveCount: Int) {
        
        initMap(carNames)

        println(RACE_START)

        repeat(moveCount) { iterateEachCar() }

        for ((carName, moveDistance) in moveProgress) {
            if (moveDistance == maxDistance) {
                winnerList.add(carName)
            }
        }


        println("\n최종 우승자 : ${winnerList.joinToString(separator = ", ")}")
    }


    private fun initMap(carNames: List<String>) = carNames.forEach { carName -> moveProgress.put(carName, BLANK) }

    private fun iterateEachCar() {
        for (carName in moveProgress.keys) {
            moveProgress[carName] += moveOrStop()

            println("$carName : ${moveProgress[carName]}")
        }
        println()
    }

    private fun randomValue(): Int = Randoms.pickNumberInRange(0, 9)

    private fun moveOrStop(): String {
        if (randomValue() >= 4) return MOVE else return STOP
    }

    private companion object {
        const val MOVE = "-"
        const val STOP = ""
        const val BLANK = ""
        const val RACE_START = "\n실행 결과"
    }
}