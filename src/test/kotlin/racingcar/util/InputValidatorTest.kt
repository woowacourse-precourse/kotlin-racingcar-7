package racingcar.util

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car

class InputValidatorTest {
    private lateinit var inputValidator: InputValidator

    @BeforeEach
    fun setUp() {
        inputValidator = InputValidator()
    }

    @Test
    fun `자동차 이름 콤마 구분 기능 테스트`() {
        val testInput = "pobi,woni,jun"
        val expected = listOf(Car("pobi"), Car("woni"), Car("jun"))
        val actual = inputValidator.getValidCarList(testInput)
        assertEquals(expected, actual)
    }

    @Nested
    @DisplayName("자동차 이름 예외 테스트")
    inner class CarNameErrorTest {
        @ParameterizedTest
        @ValueSource(strings = ["", "pobiii", "pobi,pobiii"])
        fun `차량 이름이 1-5자 사이가 아닐 경우 에러가 발생한다`(testInput: String) {
            assertThrows<IllegalArgumentException> {
                inputValidator.getValidCarList(testInput)
            }
        }

        @ParameterizedTest
        @ValueSource(strings = ["", " ", "po bi", " pobi", "pobi,", ",pobi"])
        fun `차량 이름에 공백이 있을 경우 에러가 발생한다`(testInput: String) {
            assertThrows<IllegalArgumentException> {
                inputValidator.getValidCarList(testInput)
            }
        }

        @Test
        fun `차량 이름이 중복일 경우 에러가 발생한다`() {
            val testInput = "pobi,pobi"
            assertThrows<IllegalArgumentException> {
                inputValidator.getValidCarList(testInput)
            }
        }
    }

    @Nested
    @DisplayName("시도 횟수 예외 테스트")
    inner class RoundErrorTest {
        @ParameterizedTest
        @ValueSource(strings = ["", " ", "a", " 1", "1 "])
        fun `숫자 값이 아닐 경우 에러가 발생한다`(testInput: String) {
            assertThrows<IllegalArgumentException> {
                inputValidator.getValidRounds(testInput)
            }
        }

        @ParameterizedTest
        @ValueSource(strings = ["-1", "0", "2147483648"])
        fun `1보다 작거나 Int 범위를 초과하는 경우 에러가 발생한다`(testInput: String) {
            assertThrows<IllegalArgumentException> {
                inputValidator.getValidRounds(testInput)
            }
        }
    }
}