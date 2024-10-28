package racingcar.view

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputTest {
    @Test
    fun `중복된 자동차 이름은 불가능하다`() {
        assertThrows<IllegalArgumentException> {
            InputView().validateCarNames(listOf("tama", "tama"))
        }
    }

    @Test
    fun `자동차 이름은 공백이 불가능하다`() {
        assertThrows<IllegalArgumentException> {
            InputView().validateCarNames(listOf(" ", "tama"))
        }
    }

    @Test
    fun `시도 횟수는 양수만 가능하다`() {
        assertThrows<IllegalArgumentException> {
            InputView().validateTryCount(-1)
        }
    }

}