package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {
    private lateinit var car: Car

    @BeforeEach
    fun setup() {
        car = Car("TestCar")
    }

    @Test
    @DisplayName("자동차의 초기 위치는 0이어야 한다.")
    fun car_initial_position_test() {
        assertEquals(0, car.position)
    }

    @Test
    @DisplayName("자동차의 위치는 moveForward가 한 번 호출되었을 때 1이 증가해야 한다.")
    fun car_single_moveForward_test() {
        car.moveForward()
        assertEquals(1, car.position)
    }

    @Test
    @DisplayName("자동차의 위치는 moveForward의 호출 횟수와 비례해야 한다.")
    fun car_multiple_moveForward_test() {
        repeat(5) { car.moveForward() }
        assertEquals(5, car.position)
    }
}
