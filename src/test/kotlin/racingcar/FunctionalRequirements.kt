package racingcar


import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Car
import racingcar.domain.Stadium
import racingcar.view.CommandLineView
import racingcar.view.View

class FunctionalRequirements {
    private val application = Application()
    private val stadium = Stadium()
    private val view: View = CommandLineView()

    @Test
    fun `주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다`() {
        val cars = listOf(Car("car1"), Car("car2"))
        val rounds = 5
        val raceResults = stadium.race(cars, rounds)
        raceResults.forEach { roundResult ->
            roundResult.forEach { car ->
                assertThat(car.movedDistance).isGreaterThanOrEqualTo(0)
            }
        }
    }

    @Test
    fun `각 자동차에 이름을 부여할 수 있다`() {
        val car = Car("gio")
        assertThat(car.name).isEqualTo("gio")
    }

    @Test
    fun `전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다`() {

    }

    @Test
    fun `자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다`() {
        assertThrows<IllegalArgumentException> {
            setInput("123456")
            application.run()
        }
    }

    @Test
    fun `사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다`() {
        assertDoesNotThrow {
            setInput("car1,car2\n5")
            application.run()
        }
    }

    @Test
    fun `전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다`() {

    }

    @Test
    fun `자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다`() {

    }

    @Test
    fun `우승자는 한 명 이상일 수 있다`() {

    }

    @Test
    fun `우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다`() {

    }

    @Test
    fun `사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다`() {
        assertThrows<IllegalArgumentException> {
            setInput("car1,car2\nfive")
            application.run()
        }
    }

    private fun setInput(input: String) {
        System.setIn(input.byteInputStream())
    }
}