package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingCarTest {
    @Test
    fun `자동차 이름과 횟수를 입력받는다`() {
        val inputName = "pobi,woni,jun"
        val inputRound = "5"
        val racingCar = RacingCar(inputName, inputRound)
        assertThat(racingCar.name).isEqualTo("pobi,woni,jun")
        assertThat(racingCar.number).isEqualTo("5")
    }

    @Test
    fun `이름이 6자 이상인 경우 에러가 발생한다`() {
        val lengthOver = RacingCar("abcdef,abc", "5")
        assertThrows<IllegalArgumentException> {
            lengthOver.lengthCheck()
        }
    }

    @Test
    fun `2대 미만의 자동차를 입력한 경우 에러가 발생한다`() {
        val lessThanTwo = RacingCar("abc", "5")
        assertThrows<IllegalArgumentException> {
            lessThanTwo.numberCheck()
        }
    }
}