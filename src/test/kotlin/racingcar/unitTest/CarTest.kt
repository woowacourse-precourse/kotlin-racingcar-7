package racingcar

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.Car

import camp.nextstep.edu.missionutils.Console.readLine

class CarTest : NsTest() {
    @Test
    fun `전진 기능 테스트`() {
        Assertions.assertSimpleTest {
            run("car", "1")
            assertThat(output()).contains("car", "1")
        }

    }

    override fun runMain() {
        val car = Car(readLine())
        val distance = readLine().toLong()
        car.moveForward(distance)
        println(car.name)
        println(car.distance)
    }
}
