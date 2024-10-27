package racingcar.unitTest
import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.Car

class CarTest : NsTest() {
    @Test
    fun `전진 기능 테스트`() {
        Assertions.assertRandomNumberInRangeTest(
            {
                run()
                assertThat(output()).contains("1")
            },
            MOVING_FORWARD
        )
        Assertions.assertRandomNumberInRangeTest(
            {
                run()
                assertThat(output()).contains("0")
            },
            STOP
        )
    }

    override fun runMain() {
        val car = Car("car")
        car.tryToMoveForward(1)
        println(car.distance)
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
