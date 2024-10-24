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

    fun winnerList(): List<String> {
        val moveByNameList = moveByNameList()
        val winnerList = mutableListOf<Int>()
        var moveCount = 0

        for (i in moveByNameList.indices) {
            moveCount = moveByNameList[i].count { it.contains(MOVE) }
            winnerList.add(moveCount)
        }

        val maxValue = winnerList.max()
        val maxIndex = winnerList.withIndex().filter { it.value == maxValue }.map { it.index }
        val wList = mutableListOf<String>()
        for (i in maxIndex.indices) {
            wList.add(carNameList[maxIndex[i]])
        }

        return wList
    }
}
