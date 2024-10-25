package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.util.CarValidator
import racingcar.util.CarValidator.INVALID_INPUT_CAR_NAME_DUPLICATE
import racingcar.util.CarValidator.INVALID_INPUT_CAR_NAME_LENGTH
import java.lang.reflect.InvocationTargetException

class CarValidatorTest {

    @DisplayName("자동차 이름이 5자를 초과할 때 예외 발생 테스트")
    @Test
    fun longCarNameInputTest() {
        val input = "car1,car123456"

        val method = CarValidator.javaClass.getDeclaredMethod("validateCarNameLength", List::class.java)
        method.setAccessible(true)

        try {
            method.invoke(CarValidator, input.split(","))
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            assertThat(e.cause?.message).isEqualTo(INVALID_INPUT_CAR_NAME_LENGTH)
        }
    }

    @DisplayName("구분자가 연속으로 입력되는 경우 예외 발생 테스트")
    @Test
    fun consecutiveDelimitersInputTest() {
        val input = "car1,,car2"

        val method = CarValidator.javaClass.getDeclaredMethod("validateCarNameLength", List::class.java)
        method.setAccessible(true)

        try {
            method.invoke(CarValidator, input.split(","))
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            assertThat(e.cause?.message).isEqualTo(INVALID_INPUT_CAR_NAME_LENGTH)
        }
    }

    @DisplayName("자동차 이름이 중복되는 경우 예외 발생 테스트")
    @Test
    fun duplicateCarNamesInputTest() {
        val input = "car1,car2,car1"

        val method = CarValidator.javaClass.getDeclaredMethod("validateCarNameDuplicate", List::class.java)
        method.setAccessible(true)

        try {
            method.invoke(CarValidator, input.split(","))
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            assertThat(e.cause?.message).isEqualTo(INVALID_INPUT_CAR_NAME_DUPLICATE)
        }
    }
}