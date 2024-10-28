package racingcar

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.view.InputView

class CarNameInputTest {
    private val inputView = InputView()

    @Test
    @DisplayName("빈 값 입력 시 예외 발생")
    fun validateEmptyInput_ThrowsException_WhenInputIsEmpty() {
        val input = "  "
        assertThrows(IllegalArgumentException::class.java) {
            inputView.validateEmptyInput(input)
        }
    }

    @Test
    @DisplayName("구분자가 쉼표가 아닌 경우 예외 발생")
    fun validateSeparator_ThrowsException_WhenSeparatorIsNotComma() {
        val input = "car1;car2"
        assertThrows(IllegalArgumentException::class.java) {
            inputView.validateSeparator(input)
        }
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 경우 예외 발생")
    fun validateNameLength_ThrowsException_WhenNameLengthIsExceeding() {
        val names = listOf("car123", "car2")
        assertThrows(IllegalArgumentException::class.java) {
            inputView.validateNameLength(names)
        }
    }

    @Test
    @DisplayName("자동차 이름이 중복될 경우 예외 발생")
    fun validateDuplicateNames_ThrowsException_WhenNamesAreDuplicate() {
        val names = listOf("car1", "car1", "car2")
        assertThrows(IllegalArgumentException::class.java) {
            inputView.validateDuplicateNames(names)
        }
    }

    @Test
    @DisplayName("유효한 자동차 이름 리스트 정상 처리")
    fun splitAndTrimNames_ReturnsCorrectList_WhenInputIsValid() {
        val input = "car1, car2, car3"
        val names = inputView.splitAndTrimNames(input)
        assert(names.size == 3)
        assert(names == listOf("car1", "car2", "car3"))
    }
}