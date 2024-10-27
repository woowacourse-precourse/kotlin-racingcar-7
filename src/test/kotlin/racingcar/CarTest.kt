package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @DisplayName("자동차 생성 성공")
    @Test
    fun successCreateCar() {
        val name = "우테코"
        val car = Car(name)

        assertEquals(car.name, name)
    }

    @DisplayName("자동차 생성 실패 - 빈 이름")
    @Test
    fun failCreateCarEmptyName() {
        val name = ""

        assertThrows<IllegalArgumentException> {
            Car(name)
        }
    }

    @DisplayName("자동차 생성 실패 - 너무 긴 이름")
    @Test
    fun failCreateCarLongName() {
        val name = "우테코_사랑"

        assertThrows<IllegalArgumentException> {
            Car(name)
        }
    }

    @DisplayName("자동차 거리 증가 성공")
    @Test
    fun successPlusDrivingDistance() {
        val name = "감자"
        val round = 4U

        val car = Car(name)

        for (i in 1U..round) {
            car.plusDrivingDistance()
        }

        assertEquals(car.drivingDistance, round)
    }
}