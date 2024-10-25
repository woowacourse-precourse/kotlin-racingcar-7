package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.util.TryCountValidator
import racingcar.util.TryCountValidator.INVALID_INPUT_TRY_COUNT
import java.lang.reflect.InvocationTargetException

class TryCountValidatorTest {

    @DisplayName("시도 횟수 입력이 문자인 경우 예외 발생 테스트")
    @Test
    fun notNumberTryCountInputTest() {
        val input = "칠"
        val method = TryCountValidator.javaClass.getDeclaredMethod("validateTryCount", String::class.java)
        method.setAccessible(true)

        try {
            method.invoke(TryCountValidator, input.trim())
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            assertThat(e.cause?.message).isEqualTo(INVALID_INPUT_TRY_COUNT)
        }
    }

    @DisplayName("시도 횟수 입력이 음수인 경우 예외 발생 테스트")
    @Test
    fun negativeTryCountInputTest() {
        val input = "-1"
        val method = TryCountValidator.javaClass.getDeclaredMethod("validateTryCount", String::class.java)
        method.setAccessible(true)

        try {
            method.invoke(TryCountValidator, input.trim())
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            assertThat(e.cause?.message).isEqualTo(INVALID_INPUT_TRY_COUNT)
        }
    }
}