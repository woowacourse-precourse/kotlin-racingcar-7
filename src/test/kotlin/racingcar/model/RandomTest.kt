package racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import racingcar.ApplicationTest
import java.util.Random

class RandomTest {
    @Test
    fun `randomGenerator가 3일때 false, 4일 때 true여야 한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
            {
                assertEquals(false,racingcar.model.Random().randomGenerator())
                assertEquals(true,racingcar.model.Random().randomGenerator())
            },
            3,4
        )
    }
}