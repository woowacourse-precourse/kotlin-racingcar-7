package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.model.Game

class GameTest {
    private lateinit var game: Game

    @BeforeEach
    fun setup() {
        game = Game(listOf("pobi", "crong", "honux"))
    }

    @Test
    @DisplayName("자동차 리스트가 정상적으로 반환되는지 확인")
    fun getCars_ReturnsCorrectCars() {
        val cars = game.getCars()
        assertEquals(3, cars.size)
        assertEquals("pobi", cars[0].name)
    }

    @Test
    @DisplayName("자동차가 움직였을 때 거리가 증가하는지 확인")
    fun playRound_CarsMoveForward() {
        val car = game.getCars().first()
        val initialDistance = car.distance

        game.playRound()

        assertTrue(car.distance >= initialDistance)
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 우승자로 선택되는지 확인")
    fun getWinners_ReturnsCorrectWinners() {
        // 일부러 특정 자동차만 이동
        val cars = game.getCars()
        cars[0].move() // pobi만 전진

        val winners = game.getWinners()
        assertEquals(listOf("pobi"), winners)
    }
}