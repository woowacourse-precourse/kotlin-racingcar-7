package racingcar.data

import org.junit.jupiter.api.Assertions
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

    @DisplayName("자동차 전진 조건인 4 이상의 값을 전달한 경우")
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun move(random: Int) {
        val expectedResult = 1
        val result = Car("move").move(random)
        Assertions.assertEquals(expectedResult, result)
    }

    @DisplayName("자동차 전진 조건인 4 미만의 값을 전달한 경우")
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun stop(random: Int) {
        val expectedResult = 0
        val result = Car("stop").move(random)
        Assertions.assertEquals(expectedResult, result)
    }

    @DisplayName("0 ~ 9 이외의 값을 전달하는 경우")
    @ParameterizedTest
    @ValueSource(ints = [-1, -2, 10, 11, 12])
    fun outOfNumber(random: Int) {
        assertThrows<IllegalArgumentException> { Car("out").move(random) }
    }
}