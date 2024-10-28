package racingcar.model

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("자동차 테스트 케이스")
class CarTest {

    @DisplayName("자동차의 이름의 길이가 1~5자가 아닐 경우")
    @ParameterizedTest
    @ValueSource(strings = ["", "abcdef"])
    fun nameLengthCheck(name: String) {
        assertThrows<IllegalArgumentException> { Car(name) }
    }

    @DisplayName("자동차의 이름이 공백을 포함하였을 경우")
    @ParameterizedTest
    @ValueSource(strings = [" ", "ab c", "a b", "qwer "])
    fun nameContainsSpace(name: String) {
        assertThrows<IllegalArgumentException> { Car(name) }
    }

    @DisplayName("자동차의 이름 내 줄바꿈이 있을 경우")
    @ParameterizedTest
    @ValueSource(
        strings = ["\n", "qwe\n", "\nzxc", "ab\nc", """
        w
        o
        o
        wa
    """]
    )
    fun nameContainsNewline(name: String) {
        assertThrows<IllegalArgumentException> { Car(name) }
    }

}