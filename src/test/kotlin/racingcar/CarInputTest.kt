package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.util.ConstantsUtil.DELIMITER_COMMA
import racingcar.util.ValidatorUtil.validateCarLength
import racingcar.util.ValidatorUtil.validateCarName
import racingcar.util.ValidatorUtil.validateCarsNames

class CarInputTest {
    @Test
    fun `자동차 이름이 5 초과일 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            val input = "pobiiii"
            validateCarLength(input.length)
        }

    }

    @Test
    fun `자동차 이름이 공백일 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            val input = " "
            validateCarName(input)
        }

    }

    @Test
    fun `자동차 이름이 중복일 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            val input = "pobi,pobi,jun".split(DELIMITER_COMMA)
            validateCarsNames(input)
        }
    }

}