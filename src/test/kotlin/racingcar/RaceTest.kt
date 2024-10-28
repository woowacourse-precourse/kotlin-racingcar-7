package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RaceTest {
    @Test
    fun `경주 시도 횟수 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            Race(-3, listOf(Car("a"), Car("b")))
        }
    }

    @Test
    fun `승리자 반환`() {
        assertRandomNumberInRangeTest(
            {
                val cars = listOf(Car("a"), Car("b"))
                val race = Race(1, cars)
                race.run()
                Assertions.assertEquals(listOf(cars[0]), race.getWinners())
            },
            MOVING_FORWARD, STOP
        )
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}