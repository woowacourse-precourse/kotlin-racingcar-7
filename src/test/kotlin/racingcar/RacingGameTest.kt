package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
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

    @DisplayName("자동차 이름 리스트를 입력 받아서 자동차 객체를 생성하는 기능 테스트")
    @Test
    fun generateCarsTest() {
        val input = listOf("CarA", "CarB", "CarC")
        racingGame.generateCars(input)

        val cars = racingGame.getCars()
        assertEquals(3, cars.size)
        assertEquals("CarA", cars[0].name)
        assertEquals("CarB", cars[1].name)
        assertEquals("CarC", cars[2].name)
    }

    @DisplayName("자동차 전진 성공 기능 테스트")
    @Test
    fun tryMoveSuccessTest() {
        val input = listOf("CarA")
        racingGame.generateCars(input)

        assertRandomNumberInRangeTest(
            {
                racingGame.tryRacingGame()
                assertThat(racingGame.getCars()[0].moveCount).isEqualTo(1)
            },
            5
        )
    }

    @DisplayName("자동차 전진 실패 기능 테스트")
    @Test
    fun tryMoveFailureTest() {
        val input = listOf("CarA")
        racingGame.generateCars(input)

        assertRandomNumberInRangeTest(
            {
                racingGame.tryRacingGame()
                assertThat(racingGame.getCars()[0].moveCount).isEqualTo(0)
            },
            2
        )
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
