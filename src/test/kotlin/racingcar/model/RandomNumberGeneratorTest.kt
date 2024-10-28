package racingcar.model

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest

class RandomNumberGeneratorTest {
    @RepeatedTest(1000)
    @DisplayName("생성된 난수는 0과 9 사이에 존재해야 한다.")
    fun randomNumber_range_test() {
        val generator = RandomNumberGenerator()
        val number = generator.generate()

        assertTrue(number in 0..9)
    }
}
