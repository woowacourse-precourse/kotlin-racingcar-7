package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.view.InputView

class ExceptionTest {
    private val inputView = InputView()

    @Test
    fun `입력이 비어있는 경우`() {
        assertThrows<IllegalArgumentException>("[경고] 이름을 입력해야 합니다.") {
            inputView.getNameOfCar("".split(","))
        }
    }

    @Test
    fun `이름이 알파벳이 아닌 경우`() {
        assertThrows<IllegalArgumentException>("[경고] 알파벳으로 이뤄진 이름만 입력 가능합니다.") {
            inputView.getNameOfCar("mr'pobi,woni,jun".split(","))
        }
    }

    @Test
    fun `이름이 비어있는 경우`() {
        assertThrows<IllegalArgumentException>("[경고] 비어있는 이름이 있습니다.") {
            inputView.getNameOfCar("pobi,,jun".split(","))
        }
    }

    @Test
    fun `이름이 5글자가 넘어갈 경우`() {
        assertThrows<IllegalArgumentException>("[경고] 이름은 5글자를 초과할 수 없습니다.") {
            inputView.getNameOfCar("pobi,woni,Angela".split(","))
        }
    }

    @Test
    fun `중복된 이름이 있을 경우`() {
        assertThrows<IllegalArgumentException>("[경고] 중복된 이름이 있습니다.") {
            inputView.getNameOfCar("pobi,woni,jun,jun".split(","))
        }
    }
}
