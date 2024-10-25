package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.view.InputView
import racingcar.view.InputView.Companion.INVALID_INPUT_CAR_NAME_DUPLICATE
import racingcar.view.InputView.Companion.INVALID_INPUT_CAR_NAME_LENGTH
import racingcar.view.InputView.Companion.INVALID_INPUT_EMPTY
import racingcar.view.InputView.Companion.INVALID_INPUT_TRY_COUNT
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

    @DisplayName("자동차 이름이 5자를 초과할 때 예외 발생 테스트")
    @Test
    fun longCarNameInputTest() {
        val input = "car1,car123456"

        val method = inputView.javaClass.getDeclaredMethod("validateCarNameLength", List::class.java)
        method.setAccessible(true)

        try {
            method.invoke(inputView, input.split(","))
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

        val method = inputView.javaClass.getDeclaredMethod("validateCarNameLength", List::class.java)
        method.setAccessible(true)

        try {
            method.invoke(inputView, input.split(","))
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

        val method = inputView.javaClass.getDeclaredMethod("validateCarNameDuplicate", List::class.java)
        method.setAccessible(true)

        try {
            method.invoke(inputView, input.split(","))
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            assertThat(e.cause?.message).isEqualTo(INVALID_INPUT_CAR_NAME_DUPLICATE)
        }
    }

    @DisplayName("시도 횟수 입력이 문자인 경우 예외 발생 테스트")
    @Test
    fun notNumberTryCountInputTest() {
        val input = "칠"
        val method = inputView.javaClass.getDeclaredMethod("validateTryCount", String::class.java)
        method.setAccessible(true)

        try {
            method.invoke(inputView, input.trim())
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
        val method = inputView.javaClass.getDeclaredMethod("validateTryCount", String::class.java)
        method.setAccessible(true)

        try {
            method.invoke(inputView, input.trim())
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            assertThat(e.cause?.message).isEqualTo(INVALID_INPUT_TRY_COUNT)
        }
    }
}
