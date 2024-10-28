package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.IllegalArgumentException

class ValidationTest {

    private val validation = Validation()

    @Test
    fun `자동차 이름 유효성 검사 (이름 5자 초과)`() {
        val carList = listOf(
            Car("lipton"),
            Car("Cider"),
            Car("Cola"),
        )

        assertThrows<IllegalArgumentException> {
            validation.checkCarNameLength(carList)
        }
    }

    @Test
    fun `자동차 이름 유효성 검사 (이름이 비어있을 경우)`() {
        val carList = listOf(
            Car("Cider"),
            Car("Cola"),
            Car(""),
        )

        assertThrows<IllegalArgumentException> {
            validation.checkCarNameBlank(carList)
        }
    }

    @Test
    fun `자동차 이름 유효성 검사 (중복된 이름이 있을 경우)`() {
        val carList = listOf(
            Car("Cider"),
            Car("Cola"),
            Car("Cider"),
            Car("Cola"),
        )

        assertThrows<IllegalArgumentException> {
            validation.checkCarNameDuplication(carList)
        }
    }

    @Test
    fun `자동차 이름 유효성 검사 (이름에 공백이 있을 경우)`() {
        val carList = listOf(
            Car("Ci er"),
            Car("Cola"),
        )

        assertThrows<IllegalArgumentException> {
            validation.checkContainBlank(carList)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "-", "cola", "콜라"])
    fun `시도 횟수 유효성 검사 (숫자가 아닐 경우)`(input: String) {
        assertThrows<IllegalArgumentException> {
            validation.checkRoundCountNotNumber(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "-34"])
    fun `시도 횟수 유효성 검사 (1보다 작은 수)`(input: String) {
        assertThrows<IllegalArgumentException> {
            validation.checkRoundCountNegativeInteger(input)
        }
    }
}