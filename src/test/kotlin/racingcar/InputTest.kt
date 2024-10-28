package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.view.InputView

class InputTest {
    @Test
    fun `자동자 이름 입력 확인`() {
        assertDoesNotThrow {
            InputView.validateCarNames(listOf("pobi", "woni", "jun"))
        }
    }

    @Test
    fun `자동차 이름이 빈 문자열인 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            InputView.validateCarNames(listOf("", "car"))
        }
    }

    @Test
    fun `자동차 이름이 5자 이하가 아닌 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            InputView.validateCarNames(listOf("car", "carName"))
        }
    }

    @Test
    fun `자동차 이름이 중복된 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            InputView.validateCarNames(listOf("car1", "car2", "car1"))
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 10])
    fun `시도할 횟수 입력 확인`(input: Int) {
        assertDoesNotThrow {
            InputView.validateGameRound(input)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1])
    fun `시도할 횟수가 0 또는 음수인 경우 예외 발생`(input: Int) {
        assertThrows<IllegalArgumentException> {
            InputView.validateGameRound(input)
        }
    }
}