package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `차 하나만 참여`() {
        assertSimpleTest {
            val carRacing = CarRacing("pobi")
            assertThat(carRacing.getNamesOfCars()).isEqualTo(listOf("pobi"))
        }
    }

    @Test
    fun `차 두대가 참여`() {
        assertSimpleTest {
            val carRacing = CarRacing("pobi,woni")
            assertThat(carRacing.getNamesOfCars()).isEqualTo(listOf("pobi","woni"))
        }
    }

    @Test
    fun `차 세대가 참여`() {
        assertSimpleTest {
            val carRacing = CarRacing("pobi,woni,jun")
            assertThat(carRacing.getNamesOfCars()).isEqualTo(listOf("pobi","woni","jun"))
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
