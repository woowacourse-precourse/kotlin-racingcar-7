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
        val carRacing = CarRacing("pobi")
        assertThat(carRacing.getNamesOfCars()).isEqualTo(listOf("pobi"))
    }

    @Test
    fun `차 두대가 참여`() {
        val carRacing = CarRacing("pobi,woni")
        assertThat(carRacing.getNamesOfCars()).isEqualTo(listOf("pobi","woni"))
    }

    @Test
    fun `차 세대가 참여`() {
        val carRacing = CarRacing("pobi,woni,jun")
        assertThat(carRacing.getNamesOfCars()).isEqualTo(listOf("pobi","woni","jun"))
    }

    @Test
    fun `움직이는 차의 위치`() {
        val movingCar = Car("pobi")
        var position = 0
        for (index in 4..9) {
            position = checkMovingCar(movingCar, position, index)
        }
    }

    private fun checkMovingCar(car: Car, position: Int, point: Int): Int {
        val newPosition = position + 1
        assertThat(car.position).isEqualTo(position)
        car.move(point)
        assertThat(car.position).isEqualTo(newPosition)
        return newPosition
    }

    @Test
    fun `안움직이는 차의 위치`() {
        val stoppedCar = Car("jun")
        for (index in 0..3) {
            checkStopedCar(stoppedCar, index)
        }
    }

    private fun checkStopedCar(car: Car, point: Int) {
        assertThat(car.position).isEqualTo(0)
        car.move(point)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `기능 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
            assertThrows<IllegalArgumentException> { runException("123456,b,c", "1") }
            assertThrows<IllegalArgumentException> { runException("pobi,dominic", "1") }
            assertThrows<IllegalArgumentException> { runException("pobi,jun,woni", "a") }
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
