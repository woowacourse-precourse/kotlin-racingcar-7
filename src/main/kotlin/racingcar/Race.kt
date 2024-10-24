package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Race {
    val carMove = mutableMapOf<String, String>()

    fun start(carNames: List<String>, moveCount: Int) {
        for (carName in carNames){
            carMove.put(carName, "")
        }


    }

    fun randomValue() = Randoms.pickNumberInRange(0, 9)

    fun moveOrStop(): String {
        if (randomValue() >= 4) return MOVE
        else return STOP
    }

    companion object {
        const val MOVE = "-"
        const val STOP = ""
    }
}