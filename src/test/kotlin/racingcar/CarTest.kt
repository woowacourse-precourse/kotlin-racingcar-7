package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.entity.Car

class CarTest {

    private lateinit var car: Car

    @BeforeEach
    fun setup() {
        car = Car("white")
    }

    @Test
    fun `이동 성공 테스트`() {
        car.tryMove(6)
        val expect = 1
        assertEquals(expect, car.position)
    }

    @Test
    fun `이동 실패 테스트`() {
        car.tryMove(3)
        val expect = 0
        assertEquals(expect, car.position)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 10, 123442, -23231])
    fun `숫자가 0~9가 아닐 경우 예외 발생 테스트`(tryNumber: Int) {
        assertThrows<IllegalArgumentException> {
            car.tryMove(tryNumber)
        }
    }
}