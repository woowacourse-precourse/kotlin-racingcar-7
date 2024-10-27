package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import racingcar.controller.RacingController

class RacingControllerTest {
    private val controller = RacingController()

    @Test
    fun `자동차_이름이_유효하면_자동차_이름과_전진횟수_0을_저장한다`() {
        val carState = controller.initCarState(listOf("a", "b", "c"))

        val expectedCarState = mapOf("a" to 0, "b" to 0, "c" to 0)

        assertThat(carState).isEqualTo(expectedCarState)
    }

    @Test
    fun `무작위_값이_4_이상이면_자동차가_전진한다`() {
        val controller = RacingController { FORWARD_VALUE }
        val carState = controller.initCarState(listOf("a", "b"))

        controller.updateCarStates(carState)

        assertThat(carState).isEqualTo(mapOf("a" to 1, "b" to 1))
    }

    @Test
    fun `무작위_값이_4_미만이면_자동차가_전진하지_않는다`() {
        val controller = RacingController { STOP_VALUE }
        val carState = controller.initCarState(listOf("a", "b"))

        controller.updateCarStates(carState)

        assertThat(carState).isEqualTo(mapOf("a" to 0, "b" to 0))
    }

    companion object {
        private const val FORWARD_VALUE = 4
        private const val STOP_VALUE = 3
    }
}
