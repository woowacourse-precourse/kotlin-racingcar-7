package racingcar

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import racingcar.util.CarNameValidator
import racingcar.util.ErrorMessages

class CarNameValidatorTest {

    @Test
    fun `자동차 이름이 빈 문자열인 경우`() {
        assertThatThrownBy { CarNameValidator.validateLength("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_CAR_NAME_LENGTH_ERROR)
    }

    @Test
    fun `자동차 이름이 공백인 경우`() {
        assertThatThrownBy { CarNameValidator.validateLength(" ") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_CAR_NAME_LENGTH_ERROR)
    }

    @Test
    fun `자동차 이름이 6글자 이상인 경우`() {
        assertThatThrownBy { CarNameValidator.validateLength("GyeongminKim") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_CAR_NAME_LENGTH_ERROR)
    }

    @Test
    fun `자동차 이름이 이모티콘인 경우 코드 포인트 수를 계산`() {
        val carName = "👬👬👬"

        assertDoesNotThrow {
            CarNameValidator.validateLength(carName)
        }

    }

    @Test
    fun `자동차 이름이 중복되는 경우`() {
        val carNameList = listOf("pobi", "pobi")
        assertThatThrownBy { CarNameValidator.validateDuplicate(carNameList) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_CAR_NAME_DUPLICATE_ERROR)
    }

}