package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RacingGameTest {
    @Test
    fun `횟수를 입력받는다`() {
        val inputNumber = "5"
        val racingGame = RacingGame(inputNumber)
        assertThat(racingGame.number).isEqualTo("5")
    }
}