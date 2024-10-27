package racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.strategy.MoveStrategy

class RaceGameServiceTest {
    private val fixedMoveStrategy: MoveStrategy = object : MoveStrategy {
        override fun canMove(): Boolean {
            return true
        }
    }

    private val raceGameService = RaceGameService(fixedMoveStrategy)

    @Test
    fun `랜덤 값이 4이상인 경우, 자동차는 한 칸씩 앞으로 이동한다`() {
        val cars = raceGameService.setupCars("pobi,woni")

        raceGameService.performRace(cars)

        assertThat(cars[0].position).isEqualTo(1)
        assertThat(cars[1].position).isEqualTo(1)
    }

    @Test
    fun `가장 많이 이동한 자동차가 우승자이다`() {
        val cars = listOf(
            Car("pobi").apply { moveOnce(); moveOnce(); moveOnce() },
            Car("woni").apply { moveOnce(); moveOnce() })

        val winners = raceGameService.findWinners(cars)

        assertThat(winners).hasSize(1)
        assertThat(winners[0].name).isEqualTo("pobi")
    }

    @Test
    fun `우승자가 여러 명일 경우 모두 반환한다`() {
        val cars = listOf(
            Car("pobi").apply { moveOnce(); moveOnce(); moveOnce() },
            Car("woni").apply { moveOnce(); moveOnce(); moveOnce() }
        )

        val winners = raceGameService.findWinners(cars)

        assertThat(winners).hasSize(2)
        assertThat(winners[0].name).isEqualTo("pobi")
        assertThat(winners[1].name).isEqualTo("woni")
    }
}
