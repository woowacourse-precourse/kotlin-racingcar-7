package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.constants.Constants.MOVE

class Make(private val carNames: String, private val tryCount: Int) {
    private fun randomNumber() = Randoms.pickNumberInRange(0, 9)

    fun carNameList() = carNames.split(',')
    private val carNameList = carNameList()

    private fun numberList(): List<Int> {
        val numberList = mutableListOf<Int>()

        repeat(tryCount) {
            numberList.add(randomNumber())
        }

        return numberList
    }

    fun moveByNameList(): List<List<String>> {
        val moveByNameList = mutableListOf<List<String>>()
        val numberList = numberList()

        repeat(carNameList.size) {
            moveByNameList.add(Move().moveOrStop(numberList))
        }

        return moveByNameList
    }

    private fun moveCountList(): List<Int> {
        val moveByNameList = moveByNameList()
        val moveCountList = mutableListOf<Int>()
        var moveCount = 0

        for (i in moveByNameList.indices) {
            moveCount = moveByNameList[i].count { it.contains(MOVE) }
            moveCountList.add(moveCount)
        }

        return moveCountList
    }

    fun winnerList(): List<String> {
        val moveCountList = moveCountList()
        val maxValue = moveCountList.max()
        val maxIndex = moveCountList.withIndex().filter { it.value == maxValue }.map { it.index }
        val winnerList = mutableListOf<String>()

        for (i in maxIndex.indices) {
            winnerList.add(carNameList[maxIndex[i]])
        }

        return winnerList
    }
}
