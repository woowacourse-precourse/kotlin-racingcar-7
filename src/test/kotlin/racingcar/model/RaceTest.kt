package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RaceTest {

    @Test
    fun `raceRound 호출 시 4 이상의 값이 전달되면 자동차가 이동한다`() {
        val car1 = Car("pobi")
        val car2 = Car("woni")
        val race = Race(listOf(car1, car2))

        // 4 이상의 고정된 값을 반환하여 자동차가 이동하도록 설정
        race.raceRound { MOVING_FORWARD }

        // 각 자동차의 위치가 1씩 증가했는지 확인
        assertThat(car1.position).isEqualTo(1)
        assertThat(car2.position).isEqualTo(1)
    }

    @Test
    fun `raceRound 호출 시 4 미만의 값이 전달되면 자동차가 이동하지 않는다`() {
        val car1 = Car("pobi")
        val car2 = Car("woni")
        val race = Race(listOf(car1, car2))

        race.raceRound { STOP }

        // 각 자동차의 위치가 그대로인지 확인
        assertThat(car1.position).isEqualTo(0)
        assertThat(car2.position).isEqualTo(0)
    }

    @Test
    fun `race에 참여하는 자동차 간 이름이 같은 경우`() {
        // 중복된 이름을 가진 자동차 생성
        val car1 = Car("pobi")
        val car2 = Car("pobi")
        val car3 = Car("woni")

        //오류 발생
        assertThrows<IllegalArgumentException> {
            Race(listOf(car1, car2, car3))
        }
    }


    @Test
    fun `findWinners는 가장 먼 위치에 있는 자동차를 반환한다`() {
        val car1 = Car("pobi", position = 3)
        val car2 = Car("woni", position = 5)
        val car3 = Car("jun", position = 5)
        val race = Race(listOf(car1, car2, car3))

        // 우승자 목록 검증
        val winners = race.findWinners()
        assertThat(winners).containsExactlyInAnyOrder("woni", "jun")
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}