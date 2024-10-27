package racingcar.strategy

import camp.nextstep.edu.missionutils.Randoms

private const val THRESHOLD: Int = 4
private const val STARTINCLUSIVE = 0
private const val ENDINCLUSIVE = 9

class RandomMoveStrategy : MoveStrategy {
    override fun canMove(): Boolean {
        val randomNumber = Randoms.pickNumberInRange(STARTINCLUSIVE, ENDINCLUSIVE)
        return randomNumber >= THRESHOLD
    }
}
