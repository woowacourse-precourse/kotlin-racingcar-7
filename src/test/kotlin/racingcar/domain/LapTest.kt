package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class LapTest {

    @Nested
    @DisplayName("예외 발생")
    inner class ThrowException {
        @Test
        fun `숫자가 아닌 다른값이 입력되면 예외를 출력한다`() {
            // Given
            val stringLapCount = "k"

            // When & Then
            assertThrows<IllegalArgumentException> {
                Lap(stringLapCount).count
            }.apply {
                assertThat(message).isEqualTo(LAP_COUNT_NUMBER_ERROR_MESSAGE)
            }
        }

        @Test
        fun `음수가 입력되면 예외를 발생시킨다`() {
            // Given
            val stringLapCount = "-1"

            // When & Then
            assertThrows<IllegalArgumentException> {
                Lap(stringLapCount).count
            }.apply {
                assertThat(message).isEqualTo(LAP_COUNT_POSITIVE_ERROR_MESSAGE)
            }
        }

        @Test
        fun `0이 입력되면 예외를 발생시킨다`() {
            // Given
            val stringLapCount = "0"

            // When & Then
            assertThrows<IllegalArgumentException> {
                Lap(stringLapCount).count
            }.apply {
                assertThat(message).isEqualTo(LAP_COUNT_POSITIVE_ERROR_MESSAGE)
            }
        }
    }

    @Nested
    @DisplayName("성공")
    inner class Success {
        @Test
        fun `정상적인 값이 입력되면 예외를 발생시키지 않는다`() {
            // Given
            val stringLapCount = "1"

            // When & Then
            assertDoesNotThrow {
                Lap(stringLapCount).count
            }
        }
    }

    companion object {
        private const val LAP_COUNT_NUMBER_ERROR_MESSAGE = "랩 카운트는 숫자를 입력해야 합니다."
        private const val LAP_COUNT_POSITIVE_ERROR_MESSAGE = "랩 카운트는 1회 이상 입력해야합니다."
    }
}
