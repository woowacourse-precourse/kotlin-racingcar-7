package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

data class RacingCar(
    val name: String,
    val position: Int = START_POSITION,
) {
    init {
        require(name.length in NAME_LENGTH_LIMIT) { "이름은 ${NAME_LENGTH_LIMIT.first}자 이상, ${NAME_LENGTH_LIMIT.last}자 이하만 가능합니다." }
    }

    private fun rollDice(): Int = Randoms.pickNumberInRange(DICE_MIN, DICE_MAX)

    fun isMove(): Boolean = rollDice() >= MOVE_CONDITION

    fun play(): RacingCar = copy(position = position + if (isMove()) MOVE_FORWARD else STOP)

    companion object {
        const val START_POSITION = 0
        const val DICE_MAX = 9
        const val DICE_MIN = 0
        const val MOVE_FORWARD = 1
        const val STOP = 0
        const val MOVE_CONDITION = 4

        val NAME_LENGTH_LIMIT: IntRange = 1..5
    }
}
