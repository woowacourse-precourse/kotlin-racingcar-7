package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.constants.Constants.MOVE

class Make(private val carNames: String, private val tryCount: Int) {
    private fun randomNumber() = Randoms.pickNumberInRange(0, 9)
    val carNameList = carNames.split(',')
    val moveByNameList = moveByNameList()

    private fun numberList(): List<Int> {
        val numberList = mutableListOf<Int>()

        repeat(tryCount) {
            numberList.add(randomNumber())
        }

        return numberList
    }

    fun moveByNameList(): List<List<String>> {
        val moveByNameList = mutableListOf<List<String>>()

        repeat(carNameList.size) {
            moveByNameList.add(Move().moveOrStop(numberList()))
        }

        return moveByNameList
    }

    private fun moveCountList(): List<Int> {
        val moveCountList = mutableListOf<Int>()

        for (i in moveByNameList.indices) {
            val moveCount = moveByNameList[i].count { it == MOVE }
            moveCountList.add(moveCount)
        }

        return moveCountList
    }

    fun winnerList(): List<String> {
        val moveCountList = moveCountList()
        val maxValue = moveCountList.maxOrNull()
        val maxIndex = moveCountList.withIndex().filter { it.value == maxValue }.map { it.index }
        val winnerList = mutableListOf<String>()

        for (i in maxIndex.indices) {
            winnerList.add(carNameList[maxIndex[i]])
        }

        return winnerList
    }
}
