package racingcar

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class RacingCarTest {
    @Test
    fun `쉼표가 없는 입력이 들어오면 예외가 발생한다`() {
        val validation = Validation()
        assertThatIllegalArgumentException().isThrownBy {
            validation.validateInputHasComma("pobi jason")
        }.withMessageContaining("입력에는 쉼표(,)가 포함되어야 합니다.")
    }

    @Test
    fun `5자를 초과하는 이름에 대해 예외가 발생한다`() {
        val validation = Validation()
        assertThatIllegalArgumentException().isThrownBy {
            validation.validateCarNames(listOf("pobi", "woni", "junhyeok"))
        }.withMessageContaining("이름은 5자 이하로 입력해주세요.")
    }

    @Test
    fun `시도 횟수에 숫자가 아닌 값을 입력하면 예외가 발생한다`() {
        val validation = Validation()
        assertThatIllegalArgumentException().isThrownBy {
            validation.getAttemptTimes("abc")
        }.withMessageContaining("시도 횟수를 입력해주세요.")
    }

}