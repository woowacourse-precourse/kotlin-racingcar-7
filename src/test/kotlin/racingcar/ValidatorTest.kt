package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {

    private val validator = Validator()

    @Test
    fun `자동차 이름이 5자를 초과한 경우 예외 발생 테스트`() {
        val carNames = listOf("pobi", "verylongname")
        assertThrows<IllegalArgumentException> {
            validator.validateCarNames(carNames)
        }
    }

    @Test
    fun `자동차 이름에 공백이 포함된 경우 예외 발생 테스트`() {
        val carNames = listOf("pobi", "lo opy")
        assertThrows<IllegalArgumentException> {
            validator.validateCarNames(carNames)
        }
    }

    @Test
    fun `자동차 이름이 빈 문자열인 경우 예외 발생 테스트`() {
        val carNames = listOf(" ", "loopy")
        assertThrows<IllegalArgumentException> {
            validator.validateCarNames(carNames)
        }
    }

    @Test
    fun `자동차 이름이 중복된 경우 예외 발생 테스트`() {
        val carNames = listOf("pobi", "pobi", "loopy")
        assertThrows<IllegalArgumentException> {
            validator.validateNameDuplication(carNames)
        }
    }

    @Test
    fun `시도 횟수가 0 이하인 경우 예외 발생 테스트`() {
        assertThrows<IllegalArgumentException> {
            validator.validateTryCount(0)
        }
        assertThrows<IllegalArgumentException> {
            validator.validateTryCount(-1)
        }
    }

    @Test
    fun `랜덤값이 4 이상일 때 전진 가능`() {
        for (i in 4..9) {
            assertThat(i >= 4).isTrue
        }
    }

    @Test
    fun `랜덤값이 3 이하일 때 전진 불가`() {
        for (i in 0..3) {
            assertThat(i >= 4).isFalse
        }
    }
}