package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RaceTest {
    val race = RaceGame()

    @Test
    @DisplayName("각 자동차의 전진값을 0으로 초기화")
    fun splitCarsTest() {
        val cars = "a,b,c,d,e"
        val carMap = race.splitCars(cars)

        assertThat(carMap).containsExactlyEntriesOf(
            mapOf("a" to 0, "b" to 0, "c" to 0, "d" to 0, "e" to 0)
        )
    }

    @Test
    fun goForwardTest() {
        val carMap = mutableMapOf<String, Int>("a" to 0, "b" to 0, "c" to 0, "d" to 0, "e" to 0)

        assertRandomNumberInRangeTest(
            {
                val increaseScore = race.goForward(carMap)
                assertThat(increaseScore["a"]).isEqualTo(1)
                assertThat(increaseScore["b"]).isEqualTo(0)
                assertThat(increaseScore["a"]).isEqualTo(1)
                assertThat(increaseScore["b"]).isEqualTo(0)
                assertThat(increaseScore["a"]).isEqualTo(1)
            }, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD
        )
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }

}