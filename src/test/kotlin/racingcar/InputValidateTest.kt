package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.controller.CarNameValidator
import racingcar.controller.InputValidator

class InputValidateTest {

    @Test
    fun `자동차_이름이_공백이나_빈_문자열이면_예외를_던진다`() {
        assertThrows<IllegalArgumentException> { InputValidator.validateCarName(listOf("", "  ", "\n")) }
    }

    @Test
    fun `자동차_이름이_5글자_초과이면_예외를_던진다`() {
        assertThrows<IllegalArgumentException> { InputValidator.validateCarName(listOf("kotlin", "hello1")) }
    }

    @Test
    fun `자동차_이름_중간에_공백이_포함되면_예외를_던진다`() {
        assertThrows<IllegalArgumentException> { InputValidator.validateCarName(listOf("ab  c", "d  e")) }
    }

    @Test
    fun `자동차_이름이_중복되면_예외를_던진다`() {
        assertThrows<IllegalArgumentException> { InputValidator.validateCarName(listOf("abc", "de", "abc")) }
    }

    @Test
    fun `유효한_자동차_이름_입력은_예외를_던지지_않는다`() {
        assertDoesNotThrow { InputValidator.validateCarName(listOf("javac", "alice", "car3")) }
    }

    @Test
    fun `경주_시도 횟수가_공백이나_빈_문자열이면_예외를_던진다`() {
        assertThrows<IllegalArgumentException> { InputValidator.validateRaceCount("") }
        assertThrows<IllegalArgumentException> { InputValidator.validateRaceCount(" ") }
        assertThrows<IllegalArgumentException> { InputValidator.validateRaceCount("\n") }
    }

    @Test
    fun `경주_시도 횟수가_문자이면_예외를_던진다`() {
        assertThrows<IllegalArgumentException> { InputValidator.validateRaceCount("a") }
        assertThrows<IllegalArgumentException> { InputValidator.validateRaceCount("1a") }
    }

    @Test
    fun `경주_시도 횟수가_0이하의 숫자면_예외를_던진다`() {
        assertThrows<IllegalArgumentException> { InputValidator.validateRaceCount("-1") }
        assertThrows<IllegalArgumentException> { InputValidator.validateRaceCount("0") }
    }

    @Test
    fun `유효한_경주_시도_횟수는_예외를_던지지_않는다`() {
        assertDoesNotThrow { InputValidator.validateRaceCount("1") }
        assertDoesNotThrow { InputValidator.validateRaceCount("999") }
    }
}
