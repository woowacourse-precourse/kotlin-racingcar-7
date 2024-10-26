package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.mockStatic

class CarTest {
    @Test
    fun `자동차 이름 길이 비정상 테스트`() {
        assertThrows<IllegalArgumentException> { Car("") }
        assertThrows<IllegalArgumentException> { Car("javaji") }
    }

    @Test
    fun `값 이상이면 전진한다`() {
        mockStatic(Randoms::class.java).use { mockedStatic ->
            // given
            val car = Car("pobi")
            mockedStatic
                .`when`<Int> { Randoms.pickNumberInRange(0, 9) }
                .thenReturn(4)

            // when
            val result = car.isMove()

            // then
            assertThat(result).isTrue()
        }
    }

    @Test
    fun `값 이하면 전진하지 않는다`() {
        mockStatic(Randoms::class.java).use { mockedStatic ->
            // given
            val car = Car("pobi")
            mockedStatic
                .`when`<Int> { Randoms.pickNumberInRange(0, 9) }
                .thenReturn(3)

            // when
            val result = car.isMove()

            // then
            assertThat(result).isFalse()
        }
    }

    @Test
    fun `자동차 이동 테스트`() {
        mockStatic(Randoms::class.java).use { mockedStatic ->
            val car = Car("pobi")
            mockedStatic
                .`when`<Int> { Randoms.pickNumberInRange(0, 9) }
                .thenReturn(8)

            val movedCar = car.play()

            assert(car.position + 1 == movedCar.position)
        }
    }
}
