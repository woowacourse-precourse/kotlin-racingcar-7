package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Race {
    val moveProgress = mutableMapOf<String, String>()

    fun start(carNames: List<String>, moveCount: Int) {
        
        initMap(carNames)
        println(RACE_START)

        repeat(moveCount) { iterateEachCar() }
    }


    private fun initMap(carNames: List<String>) = carNames.forEach { carName -> moveProgress.put(carName, BLANK) }


    private fun iterateEachCar() {
        for ((carName, moveDistance) in moveProgress) {
            moveProgress[carName] = moveProgress[carName] + moveOrStop()

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
        const val RACE_START = "실행 결과"
    }
}