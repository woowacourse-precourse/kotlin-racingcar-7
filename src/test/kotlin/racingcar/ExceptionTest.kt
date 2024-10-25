package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.view.InputView

class ExceptionTest {
    private val inputView = InputView()

    @Test
    fun `입력이 비어있는 경우`() {
        assertThrows<IllegalArgumentException>(ERROR_EMPTY_NAME) {
            inputView.getNameOfCar("".split(","))
        }
    }

    @Test
    fun `이름이 알파벳이 아닌 경우`() {
        assertThrows<IllegalArgumentException>(ERROR_INVALID_NAME) {
            inputView.getNameOfCar("mr'pobi,woni,jun".split(","))
        }
    }

    @Test
    fun `이름이 비어있는 경우`() {
        assertThrows<IllegalArgumentException>(ERROR_EMPTY_NAME) {
            inputView.getNameOfCar("pobi,,jun".split(","))
        }
    }

    @Test
    fun `이름이 5글자가 넘어갈 경우`() {
        assertThrows<IllegalArgumentException>(ERROR_NAME_LENGTH) {
            inputView.getNameOfCar("pobi,woni,Angela".split(","))
        }
    }

    @Test
    fun `중복된 이름이 있을 경우`() {
        assertThrows<IllegalArgumentException>(ERROR_SAME_NAME) {
            inputView.getNameOfCar("pobi,woni,jun,jun".split(","))
        }
    }

    @Test
    fun `횟수 입력이 비어있는 경우`() {
        assertThrows<IllegalArgumentException>(ERROR_ONLY_DIGIT) {
            inputView.getCount("")
        }
    }

    @Test
    fun `횟수 입력에 문자가 들어올 경우`() {
        assertThrows<IllegalArgumentException>(ERROR_ONLY_DIGIT) {
            inputView.getCount("abcd")
        }
    }

    @Test
    fun `횟수 입력에 0이 들어올 경우`() {
        assertThrows<IllegalArgumentException>(ERROR_COUNT_SIZE) {
            inputView.getCount("0")
        }
    }

    @Test
    fun `횟수 입력에 음수가 들어올 경우`() {
        assertThrows<IllegalArgumentException>(ERROR_COUNT_SIZE) {
            inputView.getCount("-10")
        }
    }

    @Test
    fun `횟수 입력에 Int 범위를 초과하는 값이 들어올 경우`() {
        assertThrows<IllegalArgumentException>(ERROR_ONLY_DIGIT) {
            inputView.getCount("2147483648")
        }
    }

    companion object {
        private const val ERROR_SAME_NAME = "[경고] 중복된 이름이 있습니다."
        private const val ERROR_EMPTY_NAME = "[경고] 비어있는 이름이 있습니다."
        private const val ERROR_INVALID_NAME = "[경고] 알파벳으로 이뤄진 이름만 입력 가능합니다."
        private const val ERROR_NAME_LENGTH = "[경고] 이름은 5글자를 초과할 수 없습니다."
        private const val ERROR_COUNT_SIZE = "[경고] 1이상이어야 합니다."
        private const val ERROR_ONLY_DIGIT = "[경고] 숫자만 입력 가능합니다."
    }
}
