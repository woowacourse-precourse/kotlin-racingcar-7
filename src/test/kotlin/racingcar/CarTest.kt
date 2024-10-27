package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    // 예외 처리 테스트
    private val car = Car("car")

    @Test
    fun `자동차 전진 테스트`() {
        car.moving(4)

        assertEquals(1, car.position)
    }
}