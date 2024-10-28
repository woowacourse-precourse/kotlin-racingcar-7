package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    // 예외 처리 테스트
    private val car = Car(TEST_CAR)

    @Test
    fun `자동차 전진 테스트1 (이동 가능)`() {
        car.moving(GO)

        assertEquals(POSITION_GO, car.position)
    }

    @Test
    fun `자동차 전진 테스트2 (이동 불가)`() {
        car.moving(STOP)

        assertEquals(POSITION_STOP, car.position)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `전진이 불가능한 상태`(input: Int) {
        val goStraight = car.isPossibleGoStraight(input)

        assertEquals(IMPOSSIBLE, goStraight)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 7, 9])
    fun `전진이 가능한 상태`(input: Int) {
        val goStraight = car.isPossibleGoStraight(input)

        assertEquals(POSSIBLE, goStraight)
    }

    companion object {
        private const val TEST_CAR = "car"
        private const val POSSIBLE = true
        private const val IMPOSSIBLE = false
        private const val GO = 4
        private const val STOP = 1
        private const val POSITION_GO = 1
        private const val POSITION_STOP = 0
    }
}