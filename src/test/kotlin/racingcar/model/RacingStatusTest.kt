package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RacingStatusTest {
    private val racingStatus = RacingStatus()

    @Test
    @DisplayName("RacingStatus 객체는 현재 레이싱 상태를 반환해야 한다.")
    fun racing_status_test() {
        val cars = listOf(
            Car("Car1", 1),
            Car("Car2", 2),
            Car("Car3", 3)
        )

        val carDto = racingStatus.getCurrentRacingStatus(cars)

        assertEquals(3, carDto.size)
        assertEquals("Car1", carDto[0].name)
        assertEquals(1, carDto[0].position)
        assertEquals("Car2", carDto[1].name)
        assertEquals(2, carDto[1].position)
        assertEquals("Car3", carDto[2].name)
        assertEquals(3, carDto[2].position)
    }
}
