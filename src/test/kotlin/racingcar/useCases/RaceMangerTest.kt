package racingcar.useCases

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.RaceResult
import racingcar.infrastructure.ConsoleOutput
import racingcar.infrastructure.Output

class RaceMangerTest {

    private lateinit var readyRacingCars: List<Car>
    private lateinit var output: ConsoleOutput
    private lateinit var raceManger: RaceManger

    @BeforeEach
    fun setObject() {
        readyRacingCars = listOf(Car("car1"), Car("car2"))
        output = ConsoleOutput()
        raceManger = RaceManger(readyRacingCars, 2, output)
    }

    @Test
    @DisplayName("자동차 게임 진행 테스트")
    fun `자동차 게임 진행 테스트`() {
        raceManger.playGame()
        readyRacingCars.forEach { assert(it.distance >= 0) }
    }

    @Test
    @DisplayName("우승자 판별 로직 테스트")
    fun `우승자 판별 로직 테스트`() {
        readyRacingCars = listOf(Car("car1", 5), Car("car2", 3))
        output = ConsoleOutput()
        raceManger = RaceManger(readyRacingCars, 2, output)

        val testWinner = raceManger.findWinners()
        val exceptWinner = RaceResult(listOf("car1"))

        assertEquals(exceptWinner, testWinner)
    }
}