package racingcar

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.view.InputView

class RoundInputTest {
    private val inputView = InputView()

    @Test
    @DisplayName("음수 입력 시 예외 발생")
    fun parseRounds_ThrowsException_WhenInputIsNegative() {
        val input = "-1"
        assertThrows(IllegalArgumentException::class.java) {
            inputView.parseRounds(input)
        }
    }

    @Test
    @DisplayName("0 입력 시 예외 발생")
    fun parseRounds_ThrowsException_WhenInputIsZero() {
        val input = "0"
        assertThrows(IllegalArgumentException::class.java) {
            inputView.parseRounds(input)
        }
    }

    @Test
    @DisplayName("문자열 입력 시 예외 발생")
    fun parseRounds_ThrowsException_WhenInputIsString() {
        val input = "invalid"
        assertThrows(IllegalArgumentException::class.java) {
            inputView.parseRounds(input)
        }
    }

    @Test
    @DisplayName("정수 범위를 초과한 값 입력 시 예외 발생")
    fun parseRounds_ThrowsException_WhenInputExceedsIntRange() {
        val input = "${Int.MAX_VALUE + 1L}"
        assertThrows(IllegalArgumentException::class.java) {
            inputView.parseRounds(input)
        }
    }

    @Test
    @DisplayName("유효한 시도 횟수 입력 시 정상 처리")
    fun parseRounds_ReturnsCorrectValue_WhenInputIsValid() {
        val input = "3"
        val rounds = inputView.parseRounds(input)
        assert(rounds == 3)
    }
}