package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(
        ints = [0, 1, 2, 3]
    )
    fun `4 미만 난수 이동 체크`(tryNumber: Int) {
        val testCar = Car("pobi", 0)
        testCar.move(tryNumber)
        assertThat(testCar.getPosition()).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(
        ints = [4, 5, 6, 7, 8, 9]
    )
    fun `4 이상 난수 이동 체크`(tryNumber: Int) {
        val testCar = Car("pobi", 0)
        testCar.move(tryNumber)
        assertThat(testCar.getPosition()).isEqualTo(1)
    }
}