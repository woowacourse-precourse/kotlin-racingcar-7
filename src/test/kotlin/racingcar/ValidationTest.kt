package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
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
}