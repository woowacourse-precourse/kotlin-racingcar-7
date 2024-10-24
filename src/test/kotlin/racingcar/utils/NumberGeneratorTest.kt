package racingcar.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NumberGeneratorTest {

    @Test
    fun `생성된 숫자가 0과 9사이의 숫자인지 확인하는 테스트`() {
        val number1 = NumberGenerator.generate()
        val number2 = NumberGenerator.generate()
        val number3 = NumberGenerator.generate()

        assertThat(0..9).contains(number1)
        assertThat(0..9).contains(number2)
        assertThat(0..9).contains(number3)
    }
}