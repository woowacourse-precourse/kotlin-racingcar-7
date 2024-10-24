package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("자동차에 대한 테스트")
class CarTest {

    @Test
    fun `자동차 이름을 넘겨줄 경우 전진 횟수가 0인 자동차 객체를 반환한다`() {
        val carName = "loopy"

        val car = Car.of(carName)

        assertEquals(Car("loopy", 0), car)
    }
}