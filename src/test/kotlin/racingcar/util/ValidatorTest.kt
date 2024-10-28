package racingcar.util

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    @Test
    @DisplayName("입력은 공백이 될 수 없다.")
    fun input_null_test() {
        val input = mutableListOf<String>()
        assertThrows<IllegalArgumentException> {
            Validator.validateInput(input)
        }
    }

    @Test
    @DisplayName("입력되는 자동차는 2대 이상 이어야 한다.")
    fun car_count_test() {
        val carList = mutableListOf("pobi")
        assertThrows<IllegalArgumentException> {
            Validator.validateInput(carList)
        }

        carList.add("woni")
        assertDoesNotThrow {
            Validator.validateInput(carList)
        }
    }

    @Test
    @DisplayName("입력되는 자동차는 중복되지 않아야 한다.")
    fun car_duplicate_test() {
        val carList = mutableListOf("pobi", "pobi")
        assertThrows<IllegalArgumentException> {
            Validator.validateInput(carList)
        }
    }

    @Test
    @DisplayName("자동차의 이름은 5자 이하 여야 한다.")
    fun car_name_length_test() {
        val carList = mutableListOf("pobi", "wonii", "jun123")
        assertThrows<IllegalArgumentException> {
            Validator.validateInput(carList)
        }
    }

    @Test
    @DisplayName("자동차의 이름은 공백이 될 수 없다.")
    fun car_name_null_test() {
        val carList = mutableListOf("pobi", "", "jun")
        assertThrows<IllegalArgumentException> {
            Validator.validateInput(carList)
        }
    }

    @Test
    @DisplayName("시도 횟수는 숫자 여야 한다.")
    fun attempt_digit_test() {
        assertThrows<IllegalArgumentException> {
            Validator.validateAttempt("1a")
        }

        assertDoesNotThrow {
            Validator.validateAttempt("1")
        }
    }

    @Test
    @DisplayName("시도 횟수는 1 이상이어야 한다.")
    fun attempt_value_test() {
        assertThrows<IllegalArgumentException> {
            Validator.validateAttempt("0")
        }

        assertThrows<IllegalArgumentException> {
            Validator.validateAttempt("-1")
        }

        assertDoesNotThrow {
            Validator.validateAttempt("1")
        }
    }
}
