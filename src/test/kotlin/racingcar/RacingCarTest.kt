package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RacingCarTest {
    @Test
    fun `자동차 이름과 횟수를 입력받는다`() {
        val inputName = "pobi,woni,jun"
        val inputRound = "5"
        val racingCar = RacingCar(inputName, inputRound)
        assertThat(racingCar.name).isEqualTo("pobi,woni,jun")
        assertThat(racingCar.number).isEqualTo("5")
    }
}