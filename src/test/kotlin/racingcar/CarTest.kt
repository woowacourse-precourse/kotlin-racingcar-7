package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    // 예외 처리 테스트
    private val car = Car("car")

    @Test
    fun `자동차 전진 테스트1 (이동 가능)`() {
        car.moving(4)

        assertEquals(1, car.position)
    }

    @Test
    fun `자동차 전진 테스트2 (이동 불가)`() {
        car.moving(1)

        assertEquals(0, car.position)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `전진이 불가능한 상태`(input: Int) {
        val goStraight = car.isPossibleGoStraight(input)

        assertEquals(false, goStraight)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 7, 9])
    fun `전진이 가능한 상태`(input: Int) {
        val goStraight = car.isPossibleGoStraight(input)

        assertEquals(true, goStraight)
    }
}