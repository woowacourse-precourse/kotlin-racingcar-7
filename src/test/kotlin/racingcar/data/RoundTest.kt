package racingcar.data

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("라운드 테스트 케이스")
class RoundTest {
    @DisplayName("라운드 수 정보가 입력되지 않았을 경우")
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = [" ", "   ", "\t", "\n"])
    fun emptyInput(input: String) {
        assertThrows<IllegalArgumentException> { Round(input) }
    }

    @DisplayName("라운드 수 정보가 1 이상의 정수가 아닐 경우")
    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "-2", "1.0", "3.2", "-3.2", "+5.8", "two", "이"])
    fun roundCountUnderMin(input: String) {
        assertThrows<IllegalArgumentException> { Round(input) }
    }
}