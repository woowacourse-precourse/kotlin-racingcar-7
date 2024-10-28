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

}