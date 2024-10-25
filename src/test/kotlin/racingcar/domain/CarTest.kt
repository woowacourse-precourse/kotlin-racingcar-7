package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    private lateinit var car1: Car
    private lateinit var car2: Car

    @BeforeEach
    fun setObject() {
        car1 = Car(name = "테스트1")
        car2 = Car("테스트2", 1)
    }

    @Test
    fun `Car 객체 생성 초기값 확인 테스트`() {
        assertEquals("테스트1", car1.name)
        assertEquals(1, car2.distance)
    }

    @Test
    fun `goOneStep 메서드가 randomNumber가 4이상일 때 _distance가 증가하는지 테스트`() {
        car1.goOneStep(4)
        car2.goOneStep(9)
        assertEquals(1, car1.distance)
        assertEquals(2, car2.distance)
    }

    @Test
    fun `goOneStep 메서드가 randomNumber가 4미만일 때 _distance가 유지되는지 테스트`() {
        car1.goOneStep(3)
        car2.goOneStep(0)
        assertEquals(0, car1.distance)
        assertEquals(1, car2.distance)
    }
}