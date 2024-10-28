package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingGameTest {
    @Test
    fun `횟수를 입력받는다`() {
        val inputNumber = "5"
        val racingGame = RacingGame(inputNumber)
        assertThat(racingGame.inputNumber).isEqualTo("5")
    }

    @Test
    fun `숫자가 아닌 횟수를 입력한 경우 에러가 발생한다`() {
        val nonNumeric = RacingGame("12a")
        assertThrows<IllegalArgumentException> {
            nonNumeric.checkNumeric()
        }
    }

    @Test
    fun `1 미만의 횟수를 입력한 경우 에러가 발생한다`() {
        val lessThanOne = RacingGame("0")
        lessThanOne.checkNumeric()
        assertThrows<IllegalArgumentException> {
            lessThanOne.checkMinimum()
        }
    }
}