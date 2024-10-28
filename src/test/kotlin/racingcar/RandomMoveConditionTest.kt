package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomMoveConditionTest {

    @Test
    fun `무작위 전진 조건 테스트`() {
        assertRandomNumberInRangeTest(
            {
                val randomMoveCondition = RandomMoveCondition()
                assertThat(randomMoveCondition.shouldMove()).isTrue()
            },
            4
        )
    }
}
