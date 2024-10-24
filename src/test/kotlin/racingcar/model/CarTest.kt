package racingcar.model

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    fun `이름 길이가 1이상 5이하가 아니면 에러를 발생시키는지 확인하는 테스트`() {
        assertThrows<IllegalArgumentException> {
            Car("abcdef")
            Car("")
        }
    }

    @Test
    fun `전진 기능 테스트`() {
        val car = Car("test")
        car.moveForward()
        car.moveForward()
        car.moveForward()

        assertThat(car.currentDistance).isEqualTo("---")
    }
}