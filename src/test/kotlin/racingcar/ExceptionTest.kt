package racingcar

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionTest {
    val check = CheckException()

    @Test
    fun `firstInput_빈문자열 또는 공백을 입력할 경우`() {
        assertThrows<IllegalArgumentException> { check.firstInput(" ") }
        assertThrows<IllegalArgumentException> { check.firstInput("") }
    }

    @Test
    fun `firstInput_자동차 이름이 공백일 경우`() {
        assertThrows<IllegalArgumentException> { check.firstInput("a,") }
        assertThrows<IllegalArgumentException> { check.firstInput(",a,b") }
    }

    @Test
    fun `firstInput_자동차 이름이 하나만 입력된 경우`() {
        assertThrows<IllegalArgumentException> { check.firstInput("a") }
    }

    @Test
    fun `firstInput_자동차 이름이 중복될 경우`() {
        assertThrows<IllegalArgumentException> { check.firstInput("a, b, c, d, e, a") }
    }


    @Test
    @DisplayName("쉼표와 자동차 이름 사이의 공백은 무시, 문자 사이의 공백은 1자로 취급")
    fun `firstInput_자동차 이름이 5자가 넘는 경우`() {
        assertThrows<IllegalArgumentException> { check.firstInput("abcd, abcde, abcdef") }
        assertThrows<IllegalArgumentException> { check.firstInput("a, b, c, d, e, f, g hijk") }
    }

    @Test
    fun `secondInput_빈문자열 또는 공백을 입력할 경우`() {
        assertThrows<IllegalArgumentException> { check.secondInput("") }
        assertThrows<IllegalArgumentException> { check.secondInput(" ") }

    }

    @Test
    @DisplayName("양의 정수가 아닌 경우: 0, 음수, 실수, 문자")
    fun `secondInput_입력 형태`() {
        assertThrows<IllegalArgumentException> { check.secondInput("0") }
        assertThrows<IllegalArgumentException> { check.secondInput("3.3") }
        assertThrows<IllegalArgumentException> { check.secondInput("-3") }
        assertThrows<IllegalArgumentException> { check.secondInput("a") }
    }

    @Test
    fun resultException() {
        assertThrows<IllegalArgumentException> { check.result(mutableMapOf("a" to 0, "b" to 0, "c" to 0)) }
    }
}