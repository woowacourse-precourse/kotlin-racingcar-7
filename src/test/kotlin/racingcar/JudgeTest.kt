package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("심판 객체에 대한 테스트")
class JudgeTest {
    private val judge = Judge()

    @Nested
    @DisplayName("우승자 판단")
    inner class WinnerFinderTest {

        @Test
        fun `경기에 참여한 자동차의 전진 횟수가 2로 모두 같을 경우 경기에 참여한 모든 자동차의 이름을 반환한다`() {
            val pobiCar = Car("pobi").run {
                repeat(2) {
                    forward()
                }
                this
            }

            val woniCar = Car("woni").run {
                repeat(2) {
                    forward()
                }
                this
            }
            val raceCars = listOf(pobiCar, woniCar)
            val result = judge.findWinnerName(raceCars)

            assertEquals(listOf("pobi", "woni"), result)
        }

        @Test
        fun `세 자동차에서 각 전진 횟수가 1, 2, 3으로 상이할 경우 가장 많이 전진한 자동차의 이름을 반환한다`() {
            val pobiCar = Car("pobi").run {
                forward()
                this
            }

            val woniCar = Car("woni").run {
                repeat(2) { forward() }
                this
            }

            val jasonCar = Car("jason").run {
                repeat(3) { forward() }
                this
            }

            val raceCars = listOf(pobiCar, woniCar, jasonCar)
            val result = judge.findWinnerName(raceCars)

            assertEquals(listOf("jason"), result)
        }

        @Test
        fun `세 자동차에서 각 전진 횟수가 3, 3, 2일 경우 가장 많이 전진한 두 자동차의 이름을 반환한다`() {
            val pobiCar = Car("pobi").run {
                repeat(3) { forward() }
                this
            }

            val woniCar = Car("woni").run {
                repeat(3) { forward() }
                this
            }

            val jasonCar = Car("jason").run {
                repeat(2) { forward() }
                this
            }

            val raceCars = listOf(pobiCar, woniCar, jasonCar)
            val result = judge.findWinnerName(raceCars)

            assertEquals(listOf("pobi", "woni"), result)
        }

        @Test
        fun `경기에 참여한 자동차가 1대일 경우 그 자동차의 이름을 반환한다`() {
            val pobiCar = Car("pobi").run {
                repeat(7) { forward() }
                this
            }

            val raceCars = listOf(pobiCar)
            val result = judge.findWinnerName(raceCars)

            assertEquals(listOf("pobi"), result)
        }
    }
}