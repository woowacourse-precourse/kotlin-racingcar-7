package racingcar.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigInteger


class BigIntegerUtilKtTest {
    @Test
    fun `times로 정한 만큼 action이 실행됨`() {
        // arrange
        var counter = 0

        // act
        repeat(BigInteger("5")) { ++counter }

        // assert
        assertThat(counter).isEqualTo(5)
    }

    @Test
    fun `times로 0을 지정하면 action이 실행되지 않음`() {
        // arrange
        var counter = 0

        // act
        repeat(BigInteger.ZERO) { ++counter }

        // assert
        assertThat(counter).isEqualTo(0)
    }

    @Test
    fun `times로 음수를 지정하면 action이 실행되지 않음`() {
        // arrange
        var counter = 0

        // act
        repeat(BigInteger("-5")) { ++counter }

        // assert
        assertThat(counter).isEqualTo(0)
    }
}
