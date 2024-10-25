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

    @Test
    fun `자동차 움직일지 여부`() {
        assertSimpleTest {
            val carMovingForward = Car("pobi")
            assertThat(carMovingForward.position).isEqualTo(0)
            carMovingForward.move(4)
            assertThat(carMovingForward.position).isEqualTo(1)
            carMovingForward.move(5)
            assertThat(carMovingForward.position).isEqualTo(2)
            carMovingForward.move(6)
            assertThat(carMovingForward.position).isEqualTo(3)
            carMovingForward.move(7)
            assertThat(carMovingForward.position).isEqualTo(4)
            carMovingForward.move(8)
            assertThat(carMovingForward.position).isEqualTo(5)
            carMovingForward.move(9)
            assertThat(carMovingForward.position).isEqualTo(6)

            val carStopped = Car("jun")
            carStopped.move(0)
            assertThat(carStopped.position).isEqualTo(0)
            carStopped.move(1)
            assertThat(carStopped.position).isEqualTo(0)
            carStopped.move(2)
            assertThat(carStopped.position).isEqualTo(0)
            carStopped.move(3)
            assertThat(carStopped.position).isEqualTo(0)
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
