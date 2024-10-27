package Model
import camp.nextstep.edu.missionutils.Randoms

interface MoveStrategy {
    fun isMovable(): Boolean
}

class RandomMoveStrategy : MoveStrategy {
    override fun isMovable(): Boolean = Randoms.pickNumberInRange(0, 9) >= 4
}