package racingcar.view

import racingcar.constants.Constants.COLON
import racingcar.constants.Constants.RESULT_MSG
import racingcar.constants.Constants.WINNERS_MSG

class Output {
    fun resultMsg(carNameList: List<String>, moveByNameList: List<List<String>>) {
        println(RESULT_MSG)
        for (j in moveByNameList[0].indices) {
            for (i in carNameList.indices) {
                println(
                    carNameList[i] + COLON +
                            moveByNameList[i]
                                .take(j + 1)
                                .joinToString("")
                )
            }
            println()
        }
    }

    fun winnerMsg(winnerList: List<String>) {
        val winners = winnerList.joinToString(", ")
        println(WINNERS_MSG + winners)
    }
}
