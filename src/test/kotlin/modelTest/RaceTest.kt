package modelTest

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racingcar.Model.Garage
import racingcar.Model.Race

class RaceTest {
    @Test
    fun `시도 횟수만큼 n대의 자동차를 전진하거나 멈출 수 있다`() {
        assertRandomNumberInRangeTest(
            {
                //given
                val nameOfCars = "hyun, pobi, woni, jun"
                val carsInGarage = Garage(nameOfCars).carsInGarage

                //when
                Race(carsInGarage).playOneRound { MOVING_FORWARD }

                //then
                assertAll(
                    {assertThat(carsInGarage.first().position).isEqualTo(MOVED_ONCE)},
                    {assertThat(carsInGarage.last().position).isEqualTo(MOVED_ONCE)}
                )
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `우승자를 구할 수 있다`() {
        assertSimpleTest {
            //given
            val nameOfCars = "hyun, pobi, woni, jun"
            val carsInGarage = Garage(nameOfCars).carsInGarage
            val race = Race(carsInGarage)

            //when
            carsInGarage.first().moveForward(MOVING_FORWARD)
            val winner = race.getWinner()

            //then
            assertThat(winner.first().name).isEqualTo(carsInGarage.first().name)
        }
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP: Int = 3
        private const val MOVED_ONCE: Int = 1
    }
}