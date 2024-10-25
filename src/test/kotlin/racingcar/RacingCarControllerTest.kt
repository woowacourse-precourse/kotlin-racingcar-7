package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.controller.RacingCarController

class RacingCarControllerTest {
    private val controller: RacingCarController = RacingCarController()

    @Test
    fun `쉼표로 구분된 이름들을 RacingCar 리스트가 생성되어야 한다`() {
        //give
        val input = "pobi,woni,jun"

        //when
        val racingCars = controller.createRacingCars(input)

        //then
        assertEquals(3, racingCars.size)
        assertEquals("pobi", racingCars[0].racingCarName)
        assertEquals("woni", racingCars[1].racingCarName)
        assertEquals("jun", racingCars[2].racingCarName)

        racingCars.forEach { car ->
            assertEquals(0, car.movementDistance)
        }
    }

    @Test
    fun `입력한 이름이 동일할 경우`() {
        val input = "pobi,pobi"

        val exception = assertThrows<IllegalArgumentException> {
            controller.createRacingCars(input)
        }
        assertEquals("자동차 이름은 중복될 수 없습니다.", exception.message)

    }
}