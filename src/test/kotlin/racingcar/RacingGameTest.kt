package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.model.RacingGame

class RacingGameTest {

    private lateinit var racingGame: RacingGame

    @BeforeEach
    fun setUp() {
        racingGame = RacingGame()
    }

    @Test
    @DisplayName("자동차 이름 리스트를 입력 받아서 자동차 객체를 생성하는 기능 테스트")
    fun generateCarsTest() {
        val input = listOf("CarA", "CarB", "CarC")
        racingGame.generateCars(input)

        val cars = racingGame.getCars()
        assertEquals(3, cars.size)
        assertEquals("CarA", cars[0].name)
        assertEquals("CarB", cars[1].name)
        assertEquals("CarC", cars[2].name)
    }

    @Test
    @DisplayName("우승자 다수인 경우 목록을 반환하는 기능 테스트")
    fun getWinnersTest() {
        val input = listOf("CarA", "CarB", "CarC")
        racingGame.generateCars(input)

        racingGame.getCars()[0].moveCount = 5
        racingGame.getCars()[1].moveCount = 3
        racingGame.getCars()[2].moveCount = 5

        val winners = racingGame.getWinners()
        assertEquals(2, winners.size)
        assertTrue(winners.contains("CarA"))
        assertTrue(winners.contains("CarC"))
    }
}
