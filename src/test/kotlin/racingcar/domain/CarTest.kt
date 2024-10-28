package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    private val randomNumber = FakeRandomNumberImpl()

    @Nested
    @DisplayName("자동차 이름 검증")
    inner class CarNameValidation {
        @Test
        fun `자동차 이름이 5글자를 초과하면 예외가 발생한다`() {
            // given
            val carName = "123456"

            // when & then
            assertThrows<IllegalArgumentException> {
                Car(carName, randomNumber)
            }.apply {
                assertThat(message).isEqualTo(CAR_NAME_LENGTH_ERROR_MESSAGE)
            }
        }

        @ParameterizedTest
        @ValueSource(strings = ["a", "ab", "abc", "abcd", "abcde"])
        fun `자동차 이름이 5글자 이하면 정상 작동한다`(name: String) {
            // given
            val carName = name

            // when & then
            assertDoesNotThrow {
                Car(carName, randomNumber)
            }
        }
    }

    @Nested
    @DisplayName("자동차 이동 검증")
    inner class CarMovement {
        @ParameterizedTest
        @ValueSource(ints = [0, 1, 2, 3])
        fun `랜덤값이 0-3이면 자동차가 움직이지 않는다`(number: Int) {
            // given
            randomNumber.setNumber(number)
            val car = Car("car", randomNumber)

            // when
            car.moveToForward()

            // then
            assertThat(car.distance).isEqualTo(INITIAL_DISTANCE_VALUE)
        }

        @ParameterizedTest
        @ValueSource(ints = [4, 5, 6, 7, 8, 9])
        fun `랜덤값이 4-9이면 자동차가 전진한다`(number: Int) {
            // given
            randomNumber.setNumber(number)
            val car = Car("car", randomNumber)

            // when
            car.moveToForward()

            // then
            assertThat(car.distance).isEqualTo(DASH)
        }

        @Test
        fun `랜덤값이 지정된 범위를 벗어나면 예외가 발생한다`() {
            // given
            randomNumber.setNumber(10)
            val car = Car("car", randomNumber)

            // when & then
            assertThrows<IllegalArgumentException> {
                car.moveToForward()
            }.apply {
                assertThat(message).isEqualTo(RANDOM_NUMBER_RANGE_ERROR_MESSAGE)
            }
        }
    }

    companion object {
        private const val INITIAL_DISTANCE_VALUE = ""
        private const val DASH = "-"
        private const val RANDOM_NUMBER_RANGE_ERROR_MESSAGE = "지정된 범위를 벗어난 랜덤숫자 입니다."
        private const val CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 다섯글자를 넘을 수 없습니다."
    }
}
