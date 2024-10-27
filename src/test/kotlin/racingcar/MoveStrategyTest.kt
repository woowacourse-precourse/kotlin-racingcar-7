package racingcar

import Model.RandomMoveStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest

class MoveStrategyTest {
    @RepeatedTest(10)
    fun `isMovable 메서드가 0과 9 사이에서 난수를 생성하여 4 이상이면 true를 반환`() {
        val strategy = RandomMoveStrategy()
        assertThat(strategy.isMovable()).isIn(true, false)
    }
}