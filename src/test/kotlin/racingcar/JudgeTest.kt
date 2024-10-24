package racingcar

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("심판 객체에 대한 테스트")
class JudgeTest {
    private val judge = Judge()

    @Nested
    @DisplayName("자동차 이름 유효성 검사")
    inner class CarNameValidatorTest {

        @Test
        fun `자동차 이름이 공백일 경우 IllegalArgumentException 을 발생시킨다`() {
            val carName = ""
            assertThrows<IllegalArgumentException> {
                judge.validateCarName(carName)
            }
        }

        @Test
        fun `자동차 이름이 5자 초과일 경우 IllegalArgumentException 을 발생시킨다`() {
            val carName = "sonson"

            assertThrows<IllegalArgumentException> {
                judge.validateCarName(carName)
            }
        }

        @Test
        fun `자동차 이름에 공백이 포함되어 있을 경우 IllegalArgumentException 을 발생시킨다`() {
            val carName = "son m"

            assertThrows<IllegalArgumentException> {
                judge.validateCarName(carName)
            }
        }

        @Test
        fun `자동차 이름이 공백으로만 이루어져있을 경우 IllegalArgumentException 을 발생시킨다`() {
            val carName = "   "

            assertThrows<IllegalArgumentException> {
                judge.validateCarName(carName)
            }
        }
    }
}