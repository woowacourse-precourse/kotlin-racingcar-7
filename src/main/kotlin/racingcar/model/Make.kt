package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.constants.Constants.MOVE

class Make(carNames: String, private val tryCount: Int) {
    val carNameList = carNames.split(',')
    val moveByNameList = moveByNameList()

    private fun randomNumber() = Randoms.pickNumberInRange(0, 9)

    private fun numberList(): List<Int> {

        return List(tryCount) { randomNumber() }
    }

    private fun moveByNameList(): List<List<String>> {
        return List(carNameList.size) { moveOrStop(numberList()) }
    }

    private fun moveCountList(): List<Int> {
        return moveByNameList.map { it.count { move -> move == MOVE } }
    }

    fun winnerList(): List<String> {
        val maxValue = moveCountList().max()

        return moveCountList()
            .withIndex()
            .filter { it.value == maxValue }
            .map { carNameList[it.index] }
    }
}
