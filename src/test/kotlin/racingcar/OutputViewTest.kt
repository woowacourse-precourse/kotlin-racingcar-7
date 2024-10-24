package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("출력값에 대한 테스트")
class OutputViewTest {
    private val outputView = OutputView()

    class OutputViewTest {

        private val outputView = OutputView()

        @ParameterizedTest
        @ValueSource(
            strings = [
                "경주 횟수는 최소 1회 이상이며, 정수만 입력 가능합니다.",
                "경주에 등록할 자동차 이름은 중복될 수 없습니다.",
                "경주에 등록할 자동차 이름은 공백을 포함할 수 없으며, 5자 이하여야 합니다.",
            ]
        )
        fun `에러를 띄울 메시지를 매개변수를 통해 넘겨줄 경우 IllegalArgumentException 발생 시 에러메시지가 같은지 확인한다`(message: String) {
            val exception = assertThrows<IllegalArgumentException> {
                outputView.printErrorMessage(message)
            }

            assertEquals(message, exception.message)
        }

        @ParameterizedTest
        @ValueSource(
            strings = [
                "경주 횟수는 최소 1회 이상이며, 정수만 입력 가능합니다.",
                "경주에 등록할 자동차 이름은 중복될 수 없습니다.",
                "경주에 등록할 자동차 이름은 공백을 포함할 수 없으며, 5자 이하여야 합니다.",
            ]
        )
        fun `에러를 띄울 메시지를 매개변수를 통해 넘겨줄 경우 IllegalArgumentException 을 발생한다`(message: String) {
            assertThrows<IllegalArgumentException> {
                outputView.printErrorMessage(message)
            }
        }
    }
}