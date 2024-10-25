package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.view.InputView
import racingcar.view.InputView.Companion.INVALID_INPUT_EMPTY
import java.lang.reflect.InvocationTargetException

class InputViewTest {

    private val inputView: InputView = InputView()

    @DisplayName("입력이 공백 문자열일 때 예외 발생 테스트")
    @Test
    fun spaceInputTest() {
        val input = "  "
        val method = inputView.javaClass.getDeclaredMethod("checkInputIsEmpty", String::class.java)
        method.setAccessible(true)

        try {
            method.invoke(inputView, input.trim())
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            assertThat(e.cause?.message).isEqualTo(INVALID_INPUT_EMPTY)
        }
    }

    @DisplayName("입력이 빈 문자열일 때 예외 발생 테스트")
    @Test
    fun emptyInputTest() {
        val input = ""
        val method = inputView.javaClass.getDeclaredMethod("checkInputIsEmpty", String::class.java)
        method.setAccessible(true)

        try {
            method.invoke(inputView, input.trim())
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            assertThat(e.cause?.message).isEqualTo(INVALID_INPUT_EMPTY)
        }
    }
}
